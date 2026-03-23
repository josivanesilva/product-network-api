package br.com.josivanesoftware.produto.controller;

import br.com.josivanesoftware.produto.dto.ProdutoRequestDTO;
import br.com.josivanesoftware.produto.dto.ProdutoResponseDTO;
import br.com.josivanesoftware.produto.enums.GeneroProduto;
import br.com.josivanesoftware.produto.enums.StatusProduto;
import br.com.josivanesoftware.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //CRIAR PRODUTO
    @PostMapping("/produzir")
    public ResponseEntity<ProdutoResponseDTO> criar(@RequestBody @Valid ProdutoRequestDTO request) {

        ProdutoResponseDTO criado = produtoService.produzirProduto(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(criado);
    }

    //LISTAR TODOS OS PRODUTOS
    @GetMapping("listarTodos")
    public ResponseEntity<List<ProdutoResponseDTO>> listar(){
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    //BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    //BUSCAR PRODUTO POR CODIGO
    @GetMapping(params = "codigo")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarPorCodigo(@RequestParam String codigo) {
        return ResponseEntity.ok(produtoService.buscarProdutoPorCodigo(codigo));
    }

    //BUSCAR PRODUTO POR STATUS
    @GetMapping(params = "status")
    public ResponseEntity<List<ProdutoResponseDTO>> listarPorStatus(@RequestParam StatusProduto status) {
        return ResponseEntity.ok(produtoService.buscarProdutoPorStatus(status));
    }

    //BUSCAR PRODUTO POR GENERO
    //@GetMapping("listarPorGenero/{genero}")
    @GetMapping(params = "genero")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarPorGenero(@RequestParam GeneroProduto genero) {
        return ResponseEntity.ok(produtoService.buscarProdutoPorGenero(genero));
    }

    //BUSCAR PRODUTO POR TAMANHO
    @GetMapping(params = "tamanho")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarPorTamanho(@RequestParam Integer tamanho) {
        return ResponseEntity.ok(produtoService.buscarProdutoPorTamanho(tamanho));
    }

    //LISTAR TODOS OS PRODUTO DO ESTOQUE DA FABRICA
    @GetMapping("/estoque/total")
    public ResponseEntity<Integer> totalEstoque() {
        return ResponseEntity.ok(produtoService.totalProdutoEstoque());
    }

    //EXCLUIR PRODUTO POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.excluirProdutoPorId(id);
        return ResponseEntity.noContent().build();
    }

}
