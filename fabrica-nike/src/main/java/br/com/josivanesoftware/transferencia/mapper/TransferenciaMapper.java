package br.com.josivanesoftware.transferencia.mapper;

import br.com.josivanesoftware.transferencia.dto.TransferenciaResponseDTO;
import br.com.josivanesoftware.transferencia.model.Transferencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransferenciaMapper {

    @Mapping(source = "notaFiscal.id", target = "notaFiscalId")
    TransferenciaResponseDTO toDto(Transferencia transferencia);
}
