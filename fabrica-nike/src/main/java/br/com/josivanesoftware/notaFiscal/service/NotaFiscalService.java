package br.com.josivanesoftware.notaFiscal.service;

import br.com.josivanesoftware.notaFiscal.dto.NotaFiscalResponseDTO;
import br.com.josivanesoftware.notaFiscal.model.NotaFiscal;
import br.com.josivanesoftware.notaFiscal.repository.NotaFiscalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class NotaFiscalService {

    private final NotaFiscalRepository notaFiscalRepository;

    public NotaFiscalService(NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

    public List<NotaFiscalResponseDTO> listarTotas() {
        return notaFiscalRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public NotaFiscalResponseDTO buscarPorId(Long id) {
        NotaFiscal notaFiscal = notaFiscalRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota Fiscal não encontrada"));

        return toDto(notaFiscal);
    }

    private NotaFiscalResponseDTO toDto(NotaFiscal notaFiscal) {
        NotaFiscalResponseDTO dto = new NotaFiscalResponseDTO();
        dto.setId(notaFiscal.getId());
        dto.setNumero(notaFiscal.getNumero());
        dto.setDataEmissao(notaFiscal.getDataEmissao());
        dto.setOrigem(notaFiscal.getOrigem());
        dto.setDestino(notaFiscal.getDestino());
        dto.setValorTotal(notaFiscal.getValorTotal());
        return dto;
    }
}
