package com.aula.udemy.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.exceptions.ObjectNotFoundException;
import com.aula.udemy.cursoudemy.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteEntity buscarCategoriaPorId(Integer idCliente) {
		
		Optional<ClienteEntity> clienteEntity = clienteRepository.findById(idCliente);
		
		return clienteEntity.orElseThrow(() -> 
					new ObjectNotFoundException("Objeto não encontrado! Id: " + idCliente + ", Tipo: " + ClienteEntity.class.getName())); 
	}
}
