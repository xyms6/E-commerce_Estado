package com.senai.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.ProdutoDTO;
import com.senai.ecommerce.entities.Produto;
import com.senai.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired 
    private ProdutoRepository repo;
    
    public List<ProdutoDTO> buscarTodos() {
        List<Produto> list = repo.findAll();
        return list.stream().map(ProdutoDTO::new).toList(); 
    }
    
    public Page<ProdutoDTO> buscarPagina(Pageable pagina) {
        Page<Produto> result = repo.findAll(pagina);
        return result.map(ProdutoDTO::new);
    }
    
    public ProdutoDTO criar(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        if (produto.getPreco() == null) {
            produto.setPreco(0.0);
        }
        produto = repo.save(produto); 
        return new ProdutoDTO(produto); 
    }
}
