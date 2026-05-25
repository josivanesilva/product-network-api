package br.com.josivanesoftware.produto.dto;

import br.com.josivanesoftware.produto.enums.GeneroProduto;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

//(entrada ao criar/atualizar)

@Data
public class ProdutoRequestDTO {

    private Long id;

    private String codigo;

    private String descricao;
    private String marca;
    private String modelo;
    private String cor;

    @NotNull
    private GeneroProduto genero;   // pode ser "MASCULINO", "FEMININO", "UNISSEX"

    //@NotNull
    //private String genero; // pode ser "MASCULINO", "FEMININO", "UNISSEX"

    private Integer tamanho;

    @Min(0)
    private Integer quantidade;

    @Min(0)
    private BigDecimal precoCusto;

    @Min(0)
    private BigDecimal precoVenda;
}
