package br.com.josivanesoftware.notaFiscal.repository;

import br.com.josivanesoftware.notaFiscal.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
    boolean existsByNumero(String numero);
}
