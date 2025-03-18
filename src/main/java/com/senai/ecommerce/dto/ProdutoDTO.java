package com.senai.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.senai.ecommerce.entities.Produto;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imgUrl;
    
    
    private List<CategoriaDTO> categoria = new ArrayList<>();

@Transactional
public ProdutoDTO inserir(ProdutoDTO dto) {
    Produto prod = new Produto();
    prod.setNome(dto.getNome());
    prod.setDescricao(dto.getDescricao());
    prod.setPreco(dto.getPreco());
    prod.setImgUrl(dto.getImgUrl());

    if (dto.getCategoria() != null) { // Verifica se a lista de categorias não é nula
        for (CategoriaDTO cat : dto.getCategoria()) {
            Categoria entity = categoriaRepository.getReferenceById(cat.getId()); // Busca a categoria pelo ID
            prod.getCategorias().add(entity); // Adiciona a categoria ao produto
        }
    }

    prod = repo.save(prod); // Salva o produto no banco de dados
    return new ProdutoDTO(prod); // Retorna o DTO do produto salvo
}
	
    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String nome, String descricao, Double preco, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }

    public ProdutoDTO(Produto p) {
        id = p.getId();
        nome = p.getNome();
        descricao = p.getDescricao();
        preco = p.getPreco() != null ? p.getPreco() : 0.0;
        imgUrl = p.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

	public List<CategoriaDTO> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriaDTO> categoria) {
		this.categoria = categoria;
	}
    
    
}
