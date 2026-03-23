package br.com.josivanesoftware.movimentacao.service;

import br.com.josivanesoftware.movimentacao.dto.MovimentacaoResponseDTO;
import br.com.josivanesoftware.movimentacao.enums.TipoMovimentacao;
import br.com.josivanesoftware.movimentacao.model.MovimentacaoEstoque;
import br.com.josivanesoftware.movimentacao.repository.MovimentacaoEstoqueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacaoEstoqueService {

    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
    }

    //REGISTRAR MOVIMENTAÇÃO
    public void registrar(Long produtoId,
                          TipoMovimentacao tipo,
                          Integer quantidade,
                          String origem,
                          String destino) {
        MovimentacaoEstoque movimentacaoEstoque = MovimentacaoEstoque.builder()
                .produtoId(produtoId)
                .tipo(tipo)
                .quantidade(quantidade)
                .origem(origem)
                .destino(destino)
                .data(LocalDateTime.now())
                .build();

        movimentacaoEstoqueRepository.save(movimentacaoEstoque);
    }

    //LISTAR TODAS
    public List<MovimentacaoResponseDTO> listarTodas() {
        return movimentacaoEstoqueRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    //LISTAR MOVIMENTAÇÃO POR PRODUTO
    public List<MovimentacaoResponseDTO> buscarMovimentacaoPorProduto(Long produtoId) {
        return movimentacaoEstoqueRepository.findByProdutoId(produtoId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    private MovimentacaoResponseDTO toDto(MovimentacaoEstoque movimentacaoEstoque) {
        MovimentacaoResponseDTO dto = new MovimentacaoResponseDTO();
        dto.setId(movimentacaoEstoque.getId());
        dto.setProdutoId(movimentacaoEstoque.getProdutoId());
        dto.setTipo(movimentacaoEstoque.getTipo());
        dto.setQuantidade(movimentacaoEstoque.getQuantidade());
        dto.setOrigem(movimentacaoEstoque.getOrigem());
        dto.setDestino(movimentacaoEstoque.getDestino());
        dto.setData(movimentacaoEstoque.getData());

        return dto;
    }
}
