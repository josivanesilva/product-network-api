package br.com.josivanesoftware.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor@Builder

public class ProdutoLoja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
