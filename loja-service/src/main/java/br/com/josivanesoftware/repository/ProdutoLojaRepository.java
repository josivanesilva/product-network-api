package br.com.josivanesoftware.repository;

import br.com.josivanesoftware.model.ProdutoLoja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoLojaRepository extends JpaRepository<ProdutoLoja, Long> {
}
