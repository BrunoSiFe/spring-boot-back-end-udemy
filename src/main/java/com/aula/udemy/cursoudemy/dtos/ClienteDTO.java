package com.aula.udemy.cursoudemy.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.services.annotations.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO {
	
	private Integer idCliente;

	@NotEmpty(message="O campo é obrigatório.")
	@Length(min=5, max=120 ,message="O campo deve ter entre 5 e 120 caracteres.")
	private String nome;

	@NotEmpty(message="O campo é obrigatório.")
	@Email(message="Email Inválido.")
	private String email;

	private String cpfCnpj;

	private Integer tipoCliente;

	public ClienteDTO() {
	}

	public ClienteDTO(Integer idCliente, String nome, String email, String cpfCnpj, Integer tipoCliente) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipoCliente = tipoCliente;
	}
	
	public ClienteDTO(ClienteEntity cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpfCnpj = cliente.getCpfCnpj();
		this.tipoCliente = cliente.getTipoCliente().getCodigoTipoCliente();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
}
