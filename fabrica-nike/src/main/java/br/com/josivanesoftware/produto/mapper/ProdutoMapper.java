package br.com.josivanesoftware.produto.mapper;

import br.com.josivanesoftware.produto.dto.ProdutoRequestDTO;
import br.com.josivanesoftware.produto.dto.ProdutoResponseDTO;
import br.com.josivanesoftware.produto.model.Produto;
import br.com.josivanesoftware.shared.mapper.GlobalMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = GlobalMapperConfig.class)
public interface ProdutoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true) // status será setado no service
    Produto toEntity(ProdutoRequestDTO dto);

    ProdutoResponseDTO toDto(Produto entity);

    List<ProdutoResponseDTO> toDtoList(List<Produto> produtos);
}
