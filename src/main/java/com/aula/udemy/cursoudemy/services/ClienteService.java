package com.aula.udemy.cursoudemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.dtos.ClienteDTO;
import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.exceptions.DataIntegrityException;
import com.aula.udemy.cursoudemy.exceptions.ObjectNotFoundException;
import com.aula.udemy.cursoudemy.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteEntity buscarClientePorId(Integer idCliente) {

		Optional<ClienteEntity> clienteEntity = clienteRepository.findById(idCliente);

		return clienteEntity.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + idCliente + ", Tipo: " + ClienteEntity.class.getName()));
	}

	public ClienteEntity atualizarCliente(ClienteDTO cliente) {
		ClienteEntity clienteEntity = buscarClientePorId(cliente.getIdCliente());
		atualizarDados(cliente,clienteEntity);
		return clienteRepository.save(clienteEntity);
	}

	public void deletarCliente(Integer idcliente) {
		buscarClientePorId(idcliente);

		try {
			clienteRepository.deleteById(idcliente);
		} catch (DataIntegrityViolationException ex) {
			throw new DataIntegrityException("Não é possível excluir esta cliente:" + idcliente);
		}
	}

	public List<ClienteEntity> listarClientes() {
		return clienteRepository.findAll();
	}

	public Page<ClienteEntity> findAllInPages(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}
	
	private void atualizarDados(ClienteDTO clienteDTO, ClienteEntity clienteEntity) {
		clienteEntity.setEmail(clienteDTO.getEmail());
		clienteEntity.setNome(clienteDTO.getNome());
	}
}
