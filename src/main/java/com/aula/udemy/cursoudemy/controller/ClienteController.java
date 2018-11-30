package com.aula.udemy.cursoudemy.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aula.udemy.cursoudemy.dtos.ClienteDTO;
import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value= "/{idCliente}",method=RequestMethod.GET)
	public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Integer idCliente) {
		
		ClienteEntity clienteEntity = clienteService.buscarClientePorId(idCliente);
		
		ClienteDTO cliente = new ClienteDTO(clienteEntity);
		
		return ResponseEntity.ok(cliente);
		
	}
	
	@RequestMapping(value = "/{idCliente}", method = RequestMethod.PATCH)
	public ResponseEntity<ClienteDTO> atualizarCliente(@RequestBody  @Valid ClienteDTO cliente,@PathVariable Integer idCliente) {
		
		cliente.setIdCliente(idCliente);
		clienteService.atualizarCliente(cliente);

		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value = "/{idCliente}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarCliente(@PathVariable Integer idCliente) {

		clienteService.deletarCliente(idCliente);

		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> listarClientes(){
		List<ClienteEntity> listaCliente = clienteService.listarClientes();
		return ResponseEntity.ok().body(listaCliente.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList()));
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> listarClientesInPages(
			@RequestParam(value="page",defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage",defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy",defaultValue="nome") String orderBy, 
			@RequestParam(value="direction",defaultValue="ASC") String direction){
		Page<ClienteEntity> listaCliente = clienteService.findAllInPages(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(listaCliente.map(cliente -> new ClienteDTO(cliente)));
	}
}
