package com.senai.ecommerce.dto;

import com.senai.ecommerce.entities.Usuario;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	
	
	public UsuarioDTO() {
		
	}
	
	
	public UsuarioDTO(Long id, String nome, String email, String telefone, String senha) {
	
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	
	
	public UsuarioDTO(Usuario entity) {

		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		telefone = entity.getTelefone();
		senha = entity.getSenha();
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
