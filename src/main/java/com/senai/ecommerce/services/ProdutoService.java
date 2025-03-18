package com.senai.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senai.ecommerce.dto.CategoriaDTO;
import com.senai.ecommerce.dto.ProdutoDTO;
import com.senai.ecommerce.entities.Categoria;
import com.senai.ecommerce.entities.Produto;
import com.senai.ecommerce.repositories.CategoriaRepository;
import com.senai.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<ProdutoDTO> buscarTodos() {
        List<Produto> produtos = produtoRepository.findAllWithCategorias();
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public Page<ProdutoDTO> buscarPagina(Pageable pagina) {
        Page<Produto> result = produtoRepository.findAll(pagina);
        return result.map(ProdutoDTO::new);
    }

    @Transactional
    public ProdutoDTO inserir(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setImgUrl(dto.getImgUrl());

        if (dto.getCategoria() != null) {
            for (CategoriaDTO cat : dto.getCategoria()) {
                Categoria categoria = categoriaRepository.getReferenceById(cat.getId());
                produto.getCategorias().add(categoria);
            }
        }

        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }
}
