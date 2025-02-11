package com.senai.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.ecommerce.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
