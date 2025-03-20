package com.senai.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.Usuario;
import com.senai.ecommerce.repositories.PedidoRepository;
import com.senai.ecommerce.repositories.UsuarioRepository;

public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public PedidoDTO inserir(PedidoDTO dto) {
		Pedido pedido = new Pedido();
		pedido.setMomento(dto.getMomento());
		pedido.setId(dto.getId());
		pedido.setStatus(dto.getStatus());
		
		Usuario usuario = new Usuario();
		usuario.setId(dto.getId());
		
		pedido = pedidoRepository.save(pedido);
		
		
		return new PedidoDTO(pedido);
	}
}
