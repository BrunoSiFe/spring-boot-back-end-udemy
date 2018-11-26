package com.aula.udemy.cursoudemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value= "/{idCliente}",method=RequestMethod.GET)
	public ResponseEntity<ClienteEntity> buscarCategoriaPorId(@PathVariable Integer idCliente) {
		
		ClienteEntity clienteEntity = clienteService.buscarCategoriaPorId(idCliente);
		
		return ResponseEntity.ok(clienteEntity);
		
	}
}
