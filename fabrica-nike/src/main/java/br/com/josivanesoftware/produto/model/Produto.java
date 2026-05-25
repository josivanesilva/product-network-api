package br.com.josivanesoftware.produto.model;

import br.com.josivanesoftware.produto.enums.GeneroProduto;
import br.com.josivanesoftware.produto.enums.StatusProduto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(unique = true)
    private String codigo;

    private String marca;
    private String descricao;
    private String modelo;
    private String cor;

    @Enumerated(EnumType.STRING)
    private GeneroProduto genero;

    @Enumerated(EnumType.STRING)
    private StatusProduto status;

    private int tamanho;
    private int quantidade;

    private BigDecimal precoCusto;
    private BigDecimal precoVenda;

}
