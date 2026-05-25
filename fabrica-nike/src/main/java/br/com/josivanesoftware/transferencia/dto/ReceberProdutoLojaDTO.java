package br.com.josivanesoftware.transferencia.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReceberProdutoLojaDTO {

    private Long produtoOrigemId;

    private String codigo;

    private String descricao;

    private String marca;

    private String modelo;

    private String cor;

    private Integer tamanho;

    private Integer quantidade;

    private BigDecimal precoVenda;
}
