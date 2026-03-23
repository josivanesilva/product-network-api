package br.com.josivanesoftware.produto.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//(entrada ao criar/atualizar)

@Data
public class ProdutoRequestDTO {

    private Long id;

    @NotBlank
    private String codigo;

    private String descricao;
    private String modelo;
    private String cor;

    @NotNull
    private String genero; // pode ser "MASCULINO", "FEMININO", "UNISSEX"

    private Integer tamanho;

    @Min(0)
    private Integer quantidade;

    @Min(0)
    private Double precoCusto;

    @Min(0)
    private Double precoVenda;
}
