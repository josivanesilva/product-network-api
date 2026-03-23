package br.com.josivanesoftware.notaFiscal.controller;

import br.com.josivanesoftware.notaFiscal.dto.NotaFiscalResponseDTO;
import br.com.josivanesoftware.notaFiscal.service.NotaFiscalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notas-fiscais")
public class NotaFiscalController {

    private final NotaFiscalService notaFiscalService;

    public NotaFiscalController(NotaFiscalService notaFiscalService) {
        this.notaFiscalService = notaFiscalService;
    }

    //LISTAR TODAS AS NOTAS FISCAIS
    @GetMapping
    public ResponseEntity<List<NotaFiscalResponseDTO>> listar() {
        return ResponseEntity.ok(notaFiscalService.listarTotas());
    }

    //BUSCAR NOTA FISCAL POR ID
    @GetMapping("/{id}")
    public ResponseEntity<NotaFiscalResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(notaFiscalService.buscarPorId(id));
    }
}
