package br.com.josivanesoftware.movimentacao.dto;

import br.com.josivanesoftware.movimentacao.enums.TipoMovimentacao;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "id",
        "produtoId",
        "tipo",
        "quantidade",
        "origem",
        "destino",
        "data"
})
@Data
public class MovimentacaoResponseDTO {

    private Long id;
    private Long produtoId;
    private TipoMovimentacao tipo;
    private Integer quantidade;
    private String origem;
    private String destino;
    private LocalDateTime data;
}
