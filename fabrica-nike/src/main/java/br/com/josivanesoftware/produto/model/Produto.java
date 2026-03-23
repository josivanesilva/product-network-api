package br.com.josivanesoftware.produto.model;

import br.com.josivanesoftware.produto.enums.GeneroProduto;
import br.com.josivanesoftware.produto.enums.StatusProduto;
import jakarta.persistence.*;
import lombok.*;

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

    private double precoCusto;
    private double precoVenda;

}
