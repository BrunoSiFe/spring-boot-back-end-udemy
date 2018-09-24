package com.aula.udemy.cursoudemy.dtos;

import java.util.List;

public class ClienteDTO {
	
	private Integer idCliente;

	private String nome;

	private String email;

	private String cpfCnpj;

	private Integer tipoCliente;

	private List<EnderecoDTO> listaEnderecos;

	public ClienteDTO() {
	}

	public ClienteDTO(Integer idCliente, String nome, String email, String cpfCnpj, Integer tipoCliente,
			List<EnderecoDTO> listaEnderecos) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipoCliente = tipoCliente;
		this.listaEnderecos = listaEnderecos;
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

	public List<EnderecoDTO> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<EnderecoDTO> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
	
	
}
