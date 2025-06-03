package com.senai.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.ecommerce.dto.UsuarioDTO;
import com.senai.ecommerce.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
  
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/salvar")
	public ResponseEntity<UsuarioDTO> salvar(@Valid @RequestBody UsuarioDTO dto) {
		dto = usuarioService.salvarUsuario(dto);
		return ResponseEntity.ok(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTO dto) {
		dto = usuarioService.atualizarUsuario(id, dto);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
		UsuarioDTO dto = usuarioService.buscarPorId(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UsuarioDTO dto) {
		boolean login = usuarioService.autenticaUsuario(dto);
		
		if(login) {
			return ResponseEntity.ok("Sucesso !!");
		} else {
			return ResponseEntity.status(401).body("Acesso negado");
		}
	}
	
}