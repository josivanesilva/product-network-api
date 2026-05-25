package br.com.josivanesoftware.transferencia.model;

import br.com.josivanesoftware.notaFiscal.model.NotaFiscal;
import br.com.josivanesoftware.transferencia.enums.StatusTransferencia;
import br.com.josivanesoftware.transferencia.enums.TransferenciaProdutos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produtoId;

    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private TransferenciaProdutos tipo;

    @Enumerated(EnumType.STRING)
    private StatusTransferencia status;

    @OneToOne
    private NotaFiscal notaFiscal;

    private LocalDateTime dataTransferencia;
}
