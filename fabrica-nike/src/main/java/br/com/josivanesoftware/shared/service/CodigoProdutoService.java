package br.com.josivanesoftware.shared.service;

import br.com.josivanesoftware.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CodigoProdutoService {

    private final ProdutoRepository produtoRepository;

    public CodigoProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public String geraCodigo() {

        String data = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        // EX: 20260325

        long count = produtoRepository.count() + 1;

        return String.format("PROD-%s-%04d", data, count);
    }
}
