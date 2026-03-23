package br.com.josivanesoftware.shared.converter;

import br.com.josivanesoftware.produto.enums.GeneroProduto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//Conversão na requisição de GET de Status para converter para toUpperCase
@Component
public class StringToGeneroProdutoConverter implements Converter<String, GeneroProduto> {

    @Override
    public GeneroProduto convert(String source) {
        if (source == null || source.isBlank()) {
            return null;
        }

        try {
            return GeneroProduto.valueOf(
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
