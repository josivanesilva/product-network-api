package br.com.josivanesoftware.transferencia.repository;

import br.com.josivanesoftware.transferencia.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    boolean existsByNotaFiscal_Id(Long notaFiscal);
}
