package com.aula.udemy.cursoudemy.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="TBL_ENDERECO")
public class EnderecoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_endereco")
	private Integer idEndereco;

	@Column(name="ds_logradouro")
	private String logradouro;

	@Column(name="ds_numero")
	private String numero;

	@Column(name="ds_complemento")
	private String complemento;

	@Column(name="ds_bairro")
	private String bairro;

	@Column(name="ds_cep")
	private String cep;

	@ManyToOne
	@JoinColumn(name="id_cliente")
	private ClienteEntity cliente;
	
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private CidadeEntity cidade;

	public EnderecoEntity() {

	}

	public EnderecoEntity(Integer idEndereco, String logradouro, String numero, String complemento, String bairro,
			String cep, ClienteEntity cliente,CidadeEntity cidade) {
		super();
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cliente = cliente;
		this.cidade = cidade;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
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

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public CidadeEntity getCidade() {
		return cidade;
	}

	public void setCidade(CidadeEntity cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		EnderecoEntity other = (EnderecoEntity) obj;
		
		if (idEndereco == null) {
			
			if (other.idEndereco != null)
				return false;
			
		} else if (!idEndereco.equals(other.idEndereco)) {
			
			return false;
			
		}
		return true;
	}

}
