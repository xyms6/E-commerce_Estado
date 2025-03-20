package com.senai.ecommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.StatusDoPedido;
import com.senai.ecommerce.entities.Usuario;
import com.senai.ecommerce.repositories.PedidoRepository;
import com.senai.ecommerce.repositories.UsuarioRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public PedidoDTO inserir(PedidoDTO dto) {
		Pedido pedido = new Pedido();
		pedido.setMomento(Instant.now());
		pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);

		// Buscar o usuário pelo ID recebido
		Usuario usuario = usuarioRepository.findById(dto.getClienteId()) // O código tenta encontrar um usuário pelo ID (dto.getClienteId()).Se não encontrar, lança um erro dizendo "Usuário não encontrado!".
			.orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

		// Associar o usuário ao pedido
		pedido.setCliente(usuario); // Define o usuário encontrado como o cliente do pedido (pedido.setCliente(usuario)).
		
		// Salvar o pedido com o cliente correto
		pedido = pedidoRepository.save(pedido); // O pedido, agora com o cliente correto, é salvo no banco (pedidoRepository.save(pedido)).
		
		return new PedidoDTO(pedido);
	}
}
