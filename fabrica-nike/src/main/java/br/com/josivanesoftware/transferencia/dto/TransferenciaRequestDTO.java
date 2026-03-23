package br.com.josivanesoftware.transferencia.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferenciaRequestDTO {

    @NotNull
    private Long produtoId;

    @NotNull
    @Min(1)
    private Integer quantidade;

    @NotNull
    private String destino; // ex: "CENTRO_DISTRIBUICAO" ou "LOJA-XYZ"

    private String requestId; // opcional para idempotência
}
