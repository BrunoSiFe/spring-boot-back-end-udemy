package com.aula.udemy.cursoudemy.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.aula.udemy.cursoudemy.services.annotations.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty(message="O campo é obrigatório.")
	@Length(min=5, max=120 ,message="O campo deve ter entre 5 e 120 caracteres.")
	private String nome;

	@NotEmpty(message="O campo é obrigatório.")
	@Email(message="Email Inválido.")
	private String email;

	@NotEmpty(message="O campo é obrigatório.")
	private String cpfCnpj;

	@NotNull(message="O campo é obrigatório.")
	private Integer tipoCliente;
	
	@NotEmpty(message="O campo é obrigatório.")
	private String logradouro;

	@NotEmpty(message="O campo é obrigatório.")
	private String numero;

	@NotEmpty(message="O campo é obrigatório.")
	private String complemento;

	@NotEmpty(message="O campo é obrigatório.")
	private String bairro;

	@NotEmpty(message="O campo é obrigatório.")
	private String cep;
	
	@NotEmpty(message="O campo é obrigatório.")
	private String telefoneCelular;
	
	private  String telefonePessoal;
	
	private String telefoneComercial;

	@NotNull(message="O campo é obrigatório.")
	private Integer codigoCidade;
	
	public ClienteNewDTO() {
		
	}

	public ClienteNewDTO(String nome, String email, String cpfCnpj, Integer tipoCliente, String logradouro,
			String numero, String complemento, String bairro, String cep, String telefoneCelular,
			String telefonePessoal, String telefoneComercial, Integer codigoCidade) {
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipoCliente = tipoCliente;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.telefoneCelular = telefoneCelular;
		this.telefonePessoal = telefonePessoal;
		this.telefoneComercial = telefoneComercial;
		this.codigoCidade = codigoCidade;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefonePessoal() {
		return telefonePessoal;
	}

	public void setTelefonePessoal(String telefonePessoal) {
		this.telefonePessoal = telefonePessoal;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public Integer getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}
	
}
