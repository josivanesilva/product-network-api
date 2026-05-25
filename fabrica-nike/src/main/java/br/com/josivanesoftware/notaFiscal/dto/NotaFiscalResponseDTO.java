package br.com.josivanesoftware.notaFiscal.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonPropertyOrder({
        "id",
        "numero",
        "dataEmissao",
        "origem",
        "destino",
        "valorTotal"
})
@Data
public class NotaFiscalResponseDTO {

    private long id;
    private String numero;
    private LocalDateTime dataEmissao;
    private String origem;
    private String destino;
    private BigDecimal valorTotal;
}
