package br.com.josivanesoftware.produto.repository;

import br.com.josivanesoftware.produto.model.Produto;
import br.com.josivanesoftware.produto.enums.StatusProduto;
import br.com.josivanesoftware.produto.enums.GeneroProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByStatus(StatusProduto status);

    List<Produto> findByGenero(GeneroProduto genero);

    List<Produto> findByCodigo(String codigo);

    List<Produto> findByTamanho(Integer tamanho);

    @Query("""
            SELECT SUM(produto.quantidade)
            FROM Produto produto
            WHERE produto.status = :status
            """)
    Integer totalProdutosNoEstoque(@Param("status") StatusProduto status);
}
