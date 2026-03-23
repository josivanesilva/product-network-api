package br.com.josivanesoftware.movimentacao.dto;

import br.com.josivanesoftware.movimentacao.enums.TipoMovimentacao;
import lombok.Data;

import java.time.LocalDateTime;

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
