package br.com.josivanesoftware.produto.service;

import br.com.josivanesoftware.produto.dto.ProdutoRequestDTO;
import br.com.josivanesoftware.produto.dto.ProdutoResponseDTO;
import br.com.josivanesoftware.produto.enums.GeneroProduto;
import br.com.josivanesoftware.produto.enums.StatusProduto;
import br.com.josivanesoftware.produto.mapper.ProdutoMapper;
import br.com.josivanesoftware.produto.model.Produto;
import br.com.josivanesoftware.produto.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    @Transactional
    public ProdutoResponseDTO produzirProduto(ProdutoRequestDTO dto) {
    // Converter DTO → Entity
        Produto produto = produtoMapper.toEntity(dto);

    // Regra de negócio: gerar código se não informado
        if (produto.getCodigo() == null || produto.getCodigo().isBlank()){
            produto.setCodigo("PROD-" + UUID.randomUUID().toString().substring(0,8));
        }

    // Regra de negócio: status inicial
        produto.setStatus(StatusProduto.PRODUZIDO);

        Produto salvo = produtoRepository.save(produto);

        return produtoMapper.toDto(salvo);
    }

    //LISTAR TODOS OS PRODUTOS
    public List<ProdutoResponseDTO> listarTodos() {
            return produtoRepository.findAll()
                    .stream()
                    .map(produtoMapper::toDto)
                    .toList();
    }

    //BUSCAR POR ID
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com id: " + id));

        return produtoMapper.toDto(produto);
    }

    //BUSCAR PRODUTO POR CODIGO
    public List<ProdutoResponseDTO> buscarProdutoPorCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo)
                .stream()
                .map(produtoMapper::toDto)
                .toList();
    }

    //BUSCAR PRODUTO POR STATUS
    public List<ProdutoResponseDTO> buscarProdutoPorStatus(StatusProduto status) {
        return produtoRepository.findByStatus(status)
                .stream()
                .map(produtoMapper::toDto)
                .toList();
    }

    //BUSCAR PRODUTO POR GENERO
    public List<ProdutoResponseDTO> buscarProdutoPorGenero(GeneroProduto genero) {
        return produtoRepository.findByGenero(genero)
                .stream()
                .map(produtoMapper::toDto)
                .toList();
    }

    //BUSCAR PRODUTO POR TAMANHO
    public List<ProdutoResponseDTO> buscarProdutoPorTamanho(Integer tamanho) {
        return produtoRepository.findByTamanho(tamanho)
                .stream()
                .map(produtoMapper::toDto)
                .toList();
    }

    //LISTAR TODOS OS PRODUTO DO ESTOQUE DA FABRICA
    public Integer totalProdutoEstoque() {
        Integer total = produtoRepository.totalProdutosNoEstoque(StatusProduto.PRODUZIDO);

        return total != null ? total : 0;
    }

    //EXCLUIR PRODUTO POR ID
    public void excluirProdutoPorId(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o id: " + id);
        }
        produtoRepository.deleteById(id);
    }

}
