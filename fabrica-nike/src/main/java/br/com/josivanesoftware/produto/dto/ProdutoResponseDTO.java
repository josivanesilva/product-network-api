package br.com.josivanesoftware.produto.dto;

import br.com.josivanesoftware.produto.enums.GeneroProduto;
import br.com.josivanesoftware.produto.enums.StatusProduto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;

//(saída do controller ordenada)

@JsonPropertyOrder({
        "id",
        "codigo",
        "marca",
        "descricao",
        "modelo",
        "cor",
        "genero",
        "status",
        "tamanho",
        "quantidade",
        "precoCusto",
        "precoVenda"
})

@Data
public class ProdutoResponseDTO {

    private Long id;
    private String codigo;
    private String marca;
    private String descricao;
    private String modelo;
    private String cor;
    private GeneroProduto genero;
    private StatusProduto status;
    private Integer tamanho;
    private Integer quantidade;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
}
