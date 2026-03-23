package br.com.josivanesoftware.transferencia.service;

import br.com.josivanesoftware.movimentacao.service.MovimentacaoEstoqueService;
import br.com.josivanesoftware.notaFiscal.model.NotaFiscal;
import br.com.josivanesoftware.notaFiscal.repository.NotaFiscalRepository;
import br.com.josivanesoftware.produto.enums.StatusProduto;
import br.com.josivanesoftware.produto.model.Produto;
import br.com.josivanesoftware.produto.repository.ProdutoRepository;
import br.com.josivanesoftware.transferencia.dto.TransferenciaRequestDTO;
import br.com.josivanesoftware.transferencia.dto.TransferenciaResponseDTO;
import br.com.josivanesoftware.transferencia.enums.TransferenciaProdutos;
import br.com.josivanesoftware.transferencia.mapper.TransferenciaMapper;
import br.com.josivanesoftware.transferencia.model.Transferencia;
import br.com.josivanesoftware.transferencia.repository.TransferenciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferenciaService {

    private final ProdutoRepository produtoRepository;
    private final TransferenciaRepository transferenciaRepository;
    private final NotaFiscalRepository notaFiscalRepository;
    private final TransferenciaMapper transferenciaMapper;
    private final MovimentacaoEstoqueService movimentacaoEstoqueService;

    public TransferenciaService(
            ProdutoRepository produtoRepository,
            TransferenciaRepository transferenciaRepository,
            NotaFiscalRepository notaFiscalRepository,
            TransferenciaMapper transferenciaMapper, MovimentacaoEstoqueService movimentacaoEstoqueService) {
        this.produtoRepository = produtoRepository;
        this.transferenciaRepository = transferenciaRepository;
        this.notaFiscalRepository = notaFiscalRepository;
        this.transferenciaMapper = transferenciaMapper;
        this.movimentacaoEstoqueService = movimentacaoEstoqueService;
    }

    //CRIAR TRANSFERENCIA
    public TransferenciaResponseDTO transferir(TransferenciaRequestDTO dto) {

        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        if (produto.getQuantidade() < dto.getQuantidade()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estoque insuficiente");
        }

        // DIMINUIR DO ESTOQUE DA FÀBRICA PARA A TRANSFERENCIA.
        produto.setQuantidade(produto.getQuantidade() - dto.getQuantidade());
        produto.setStatus(StatusProduto.TRANSFERIDO);
        produtoRepository.save(produto);

        //GERAR A NOTA FISCAL DE TRANSFERÊNCIA:
        NotaFiscal nota = NotaFiscal.builder()
                .numero(gerarNumeroNota())
                .dataEmissao(LocalDateTime.now())
                .origem("Fabrica")
                .destino(dto.getDestino())
                .valorTotal(produto.getPrecoVenda() * dto.getQuantidade())
                .build();
        notaFiscalRepository.save(nota);

        //CRIAR TRANSFERENCIA DO PRODUTO:
        Transferencia transferencia = Transferencia.builder()
                .produtoId(produto.getId())
                .quantidade(dto.getQuantidade())
                .tipo(TransferenciaProdutos.FABRICA_PARA_LOJA)
                .notaFiscal(nota)
                .dataTransferencia(LocalDateTime.now())
                .build();
        Transferencia salva = transferenciaRepository.save(transferencia);

        //ATUALIZAR STATUS LOJA
//       produto.setStatus(StatusProduto.EM_ESTOQUE_LOJA);
//       produtoRepository.save(produto);

        return montarResponse(salva);
    }

    private String gerarNumeroNota() {
        return "NF-" + System.currentTimeMillis();
    }

    private TransferenciaResponseDTO montarResponse(Transferencia transferencia) {
        TransferenciaResponseDTO dto = new TransferenciaResponseDTO();
        dto.setId(transferencia.getId());
        dto.setProdutoId(transferencia.getProdutoId());
        dto.setNotaFiscalId(transferencia.getNotaFiscal().getId());
        dto.setDataTransferencia(transferencia.getDataTransferencia());
        return dto;
    }

    //LISTAR TODAS AS TRANSFERENCIAS
    public List<TransferenciaResponseDTO> listarTodas() {
        return transferenciaRepository.findAll()
                .stream()
                .map(this::montarResponse)
                .toList();
    }

    //BUSCAR POR ID A TRANSFERENCIA
    public TransferenciaResponseDTO buscarPorId(Long id) {
        Transferencia transferencia = transferenciaRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Transferência não encontrada."));
        return montarResponse(transferencia);
    }
}
