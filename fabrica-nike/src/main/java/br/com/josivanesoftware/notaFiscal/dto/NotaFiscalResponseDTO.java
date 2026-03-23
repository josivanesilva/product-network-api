package br.com.josivanesoftware.notaFiscal.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotaFiscalResponseDTO {

    private long id;
    private String numero;
    private LocalDateTime dataEmissao;
    private String origem;
    private String destino;
    private Double valorTotal;
}
