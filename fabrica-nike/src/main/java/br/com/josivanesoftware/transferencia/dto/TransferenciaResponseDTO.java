package br.com.josivanesoftware.transferencia.dto;

import br.com.josivanesoftware.transferencia.enums.TransferenciaProdutos;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransferenciaResponseDTO {

    private Long id;
    private Long produtoId;
    private TransferenciaProdutos tipo;
    private Long notaFiscalId;
    private LocalDateTime dataTransferencia;
}
