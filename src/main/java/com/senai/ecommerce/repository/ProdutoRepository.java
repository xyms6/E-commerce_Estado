package com.senai.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.ecommerce.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

}
