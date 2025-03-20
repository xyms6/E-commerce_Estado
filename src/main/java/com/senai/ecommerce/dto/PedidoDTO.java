package com.senai.ecommerce.dto;

import java.time.Instant;

import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.StatusDoPedido;

public class PedidoDTO {

	
	private Long id;
	private Instant momento;
	private StatusDoPedido status;
	private Long clienteId;
	
	public PedidoDTO() {
		
	}
	
	public PedidoDTO(Long id, Instant momento, StatusDoPedido status, Long clienteId) {
		
		this.id = id;
		this.momento = momento;
		this.status = status;
		this.clienteId = clienteId;
	}
	
	
	public PedidoDTO(Pedido entity) {
		
		id = entity.getId();
		momento = entity.getMomento();
		status = entity.getStatus();
		clienteId = entity.getCliente().getId();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getMomento() {
		return momento;
	}


	public void setMomento(Instant momento) {
		this.momento = momento;
	}


	public StatusDoPedido getStatus() {
		return status;
	}


	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	
	
	
}
