package br.com.josivanesoftware.service;

import br.com.josivanesoftware.model.ProdutoLoja;
import br.com.josivanesoftware.dto.ReceberProdutoDTO;
import br.com.josivanesoftware.repository.ProdutoLojaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService {

    private final ProdutoLojaRepository produtoLojaRepository;

    public LojaService(ProdutoLojaRepository produtoLojaRepository) {
        this.produtoLojaRepository = produtoLojaRepository;
    }

    public ProdutoLoja receberProduto(ReceberProdutoDTO dto) {

        ProdutoLoja produto = ProdutoLoja.builder()
                .produtoOrigemId(dto.getProdutoOrigemId())
                .codigo(dto.getCodigo())
                .descricao(dto.getDescricao())
                .marca(dto.getMarca())
                .modelo(dto.getModelo())
                .cor(dto.getCor())
                .tamanho(dto.getTamanho())
                .quantidade(dto.getQuantidade())
                .precoVenda(dto.getPrecoVenda())
                .build();

        return produtoLojaRepository.save(produto);
    }

    public List<ProdutoLoja> listar() {
        return produtoLojaRepository.findAll();
    }
}
