package br.com.josivanesoftware.transferencia.controller;

import br.com.josivanesoftware.transferencia.dto.TransferenciaRequestDTO;
import br.com.josivanesoftware.transferencia.dto.TransferenciaResponseDTO;
import br.com.josivanesoftware.transferencia.service.TransferenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    //CRIAR TRANSFERENCIA
    @PostMapping
    public ResponseEntity<TransferenciaResponseDTO> transferir(@RequestBody @Valid TransferenciaRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(transferenciaService.transferir(dto));
    }

    //LISTAR TODAS AS TRANSFERENCIAS
    @GetMapping
    public ResponseEntity<List<TransferenciaResponseDTO>> listarTodasTransferencias() {
        return ResponseEntity.ok(transferenciaService.listarTodas());
    }

    //BUSCAR POR ID A TRANSFERENCIA
    @GetMapping("/{id}")
    public ResponseEntity<TransferenciaResponseDTO> buscarTransferenciaPorID(@PathVariable long id) {
        return ResponseEntity.ok(transferenciaService.buscarPorId(id));
    }

}
