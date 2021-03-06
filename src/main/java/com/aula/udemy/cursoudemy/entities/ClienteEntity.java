package com.aula.udemy.cursoudemy.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.aula.udemy.cursoudemy.constants.enums.TipoClienteEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="TBL_CLIENTE")
public class ClienteEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Integer idCliente;

	@Column(name="DS_NOME")
	private String nome;

	@Column(name="DS_EMAIL",unique=true)
	private String email;

	@Column(name="DS_CPF_CNPJ")
	private String cpfCnpj;

	@Column(name="CD_TIPO_CLIENTE")
	private Integer tipoCliente;

	@OneToMany(mappedBy="cliente",cascade=CascadeType.ALL)
	private List<EnderecoEntity> listaEnderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name="TBL_TELEFONE")
	private Set<String> listaTelefones = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<PedidoEntity> pedidos = new ArrayList<>();

	public ClienteEntity() {

	}

	public ClienteEntity(Integer idCliente, String nome, String email, String cpfCnpj, TipoClienteEnum tipoCliente) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipoCliente = (tipoCliente != null) ? tipoCliente.getCodigoTipoCliente() : null;
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

	public TipoClienteEnum getTipoCliente() {
		return TipoClienteEnum.toEnum(this.tipoCliente);
	}

	public void setTipoCliente(TipoClienteEnum tipoCliente) {
		this.tipoCliente = tipoCliente.getCodigoTipoCliente();
	}

	public List<EnderecoEntity> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<EnderecoEntity> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}

	public Set<String> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(Set<String> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	
	public List<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		
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
		
		ClienteEntity other = (ClienteEntity) obj;
		
		if (idCliente == null) {
			
			if (other.idCliente != null)
				return false;
			
		} else if (!idCliente.equals(other.idCliente)) {
			
			return false;
			
		}
			
		return true;
	}

}
