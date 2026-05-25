package br.com.josivanesoftware.transferencia.dto;

import br.com.josivanesoftware.transferencia.enums.StatusTransferencia;
import br.com.josivanesoftware.transferencia.enums.TransferenciaProdutos;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "id",
        "produtoId",
        "tipo",
        "notaFiscalId",
        "dataTransferencia"
})
@Data
public class TransferenciaResponseDTO {

    private Long id;
    private Long produtoId;
    private TransferenciaProdutos tipo;
    private Long notaFiscalId;
    private LocalDateTime dataTransferencia;
    private StatusTransferencia status;
}
