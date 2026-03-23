package br.com.josivanesoftware.shared.converter;

import br.com.josivanesoftware.produto.enums.StatusProduto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//Conversão na requisição de GET de Status para converter para toUpperCase
@Component
public class StringToStatusProdutoConverter implements Converter<String, StatusProduto> {

    @Override
    public StatusProduto convert(String source) {
        if (source == null || source.isBlank()) {
            return null;
        }

        try {
            return StatusProduto.valueOf(
                    source
                            .trim()
                            .toUpperCase()
                            .replace("-", "_")
                            .replace(" ", "_")

            );
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
