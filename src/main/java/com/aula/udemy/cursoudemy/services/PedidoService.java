package com.aula.udemy.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.entities.PedidoEntity;
import com.aula.udemy.cursoudemy.exceptions.ObjectNotFoundException;
import com.aula.udemy.cursoudemy.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public PedidoEntity buscarCategoriaPorId(Integer idPedido) {
		
		Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(idPedido);
		
		return pedidoEntity.orElseThrow(() -> 
					new ObjectNotFoundException("Objeto não encontrado! Id: " + idPedido + ", Tipo: " + PedidoEntity.class.getName())); 
	}
	
}
