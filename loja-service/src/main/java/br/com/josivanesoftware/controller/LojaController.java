package br.com.josivanesoftware.controller;

import br.com.josivanesoftware.model.ProdutoLoja;
import br.com.josivanesoftware.dto.ReceberProdutoDTO;
import br.com.josivanesoftware.service.LojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loja")
public class LojaController {

    private final LojaService lojaService;


    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping("/receber")
    public ResponseEntity<ProdutoLoja> receber(@RequestBody ReceberProdutoDTO dto){
        return ResponseEntity.ok(lojaService.receberProduto(dto)
        );
    }

    @GetMapping
    public ResponseEntity<List<ProdutoLoja>> listar() {
        return ResponseEntity.ok(lojaService.listar());
    }
}
