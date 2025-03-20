package com.senai.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.services.PedidoService;

@RestController
@RequestMapping(value = "pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	public ResponseEntity<PedidoDTO> inserir(@RequestBody PedidoDTO dto){
		dto = pedidoService.inserir(dto);
		return ResponseEntity.ok(dto);
	}
}
