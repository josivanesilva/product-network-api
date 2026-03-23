package br.com.josivanesoftware.produto.dto;

import lombok.Data;

//(saída do controller)

@Data
public class ProdutoResponseDTO {

    private Long id;
    private String codigo;
    private String marca;
    private String descricao;
    private String modelo;
    private String cor;
    private String genero;
    private String status;
    private Integer tamanho;
    private Integer quantidade;
    private Double precoCusto;
    private Double precoVenda;
}
