package com.aula.udemy.cursoudemy.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.constants.enums.TipoClienteEnum;
import com.aula.udemy.cursoudemy.dtos.ClienteDTO;
import com.aula.udemy.cursoudemy.dtos.ClienteNewDTO;
import com.aula.udemy.cursoudemy.entities.CidadeEntity;
import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.entities.EnderecoEntity;
import com.aula.udemy.cursoudemy.exceptions.DataIntegrityException;
import com.aula.udemy.cursoudemy.exceptions.ObjectNotFoundException;
import com.aula.udemy.cursoudemy.repositories.ClienteRepository;
import com.aula.udemy.cursoudemy.repositories.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public ClienteEntity buscarClientePorId(Integer idCliente) {

		Optional<ClienteEntity> clienteEntity = clienteRepository.findById(idCliente);

		return clienteEntity.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + idCliente + ", Tipo: " + ClienteEntity.class.getName()));
	}
	
	@Transactional
	public ClienteEntity inserirCliente(ClienteNewDTO cliente) {
		ClienteEntity clienteEntity = converterNewClienteParaEntity(cliente);
		clienteEntity = clienteRepository.save(clienteEntity);
		enderecoRepository.saveAll(clienteEntity.getListaEnderecos());
		return clienteEntity;
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
	
	private ClienteEntity converterNewClienteParaEntity(ClienteNewDTO cliente) {
		ClienteEntity clienteEntity = new ClienteEntity(null,cliente.getNome(),cliente.getEmail(),cliente.getCpfCnpj(),TipoClienteEnum.toEnum(cliente.getTipoCliente()));
		CidadeEntity cidadeEntity = new CidadeEntity(cliente.getCodigoCidade(),null,null);
		EnderecoEntity enderecoEntity = new EnderecoEntity(null,cliente.getLogradouro(),cliente.getNumero(),cliente.getComplemento(),cliente.getBairro(),cliente.getCep(),clienteEntity,cidadeEntity);

		clienteEntity.getListaEnderecos().add(enderecoEntity);
		
		clienteEntity.getListaTelefones().add(cliente.getTelefoneCelular());
		
		if(cliente.getTelefoneComercial() != null) 
			clienteEntity.getListaTelefones().add(cliente.getTelefoneComercial());
		
		if(cliente.getTelefonePessoal() != null) 
			clienteEntity.getListaTelefones().add(cliente.getTelefonePessoal());
		
		return clienteEntity;
	}
}
