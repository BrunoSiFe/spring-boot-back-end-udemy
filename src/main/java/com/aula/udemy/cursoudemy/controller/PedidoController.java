package com.aula.udemy.cursoudemy.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aula.udemy.cursoudemy.entities.PedidoEntity;
import com.aula.udemy.cursoudemy.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value= "/{idPedido}",method=RequestMethod.GET)
	public ResponseEntity<PedidoEntity> buscarCategoriaPorId(@PathVariable Integer idPedido) {
		
		PedidoEntity pedidoEntity = pedidoService.buscarCategoriaPorId(idPedido);
		
		return ResponseEntity.ok(pedidoEntity);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserirCategoria(@RequestBody @Valid PedidoEntity pedidoEntity) {

		PedidoEntity pedidoInserido = pedidoService.inserirPedido(pedidoEntity);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPedido}")
				.buildAndExpand(pedidoInserido.getIdPedido()).toUri();
		
		return ResponseEntity.created(uri).build();

	}
}
