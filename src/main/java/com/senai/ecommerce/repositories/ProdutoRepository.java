package com.senai.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.ecommerce.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.categorias")
    List<Produto> findAllWithCategorias();
}
