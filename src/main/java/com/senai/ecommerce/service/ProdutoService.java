package com.senai.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.entities.Produto;
import com.senai.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;
	
	public List<Produto> buscarTodos() {
	List<Produto> list = repo.findAll();
		return list;
	}
}
