package com.aula.udemy.cursoudemy.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="TBL_PEDIDO")
public class PedidoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PEDIDO")
	private Integer idPedido;

	@Column(name="DT_PEDIDO")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataPedido;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy ="pedido")
	private PagamentoEntity pagamento;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private ClienteEntity cliente;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="id_endereco")
	private EnderecoEntity enderecoEntrega;
	
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedidoEntity> itens = new HashSet<>();

	public PedidoEntity() {
	}

	public PedidoEntity(Integer idPedido, Date dataPedido, ClienteEntity cliente,
			EnderecoEntity enderecoEntrega) {
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public PagamentoEntity getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoEntity pagamento) {
		this.pagamento = pagamento;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public EnderecoEntity getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoEntity enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	public Set<ItemPedidoEntity> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedidoEntity> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		
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
		
		PedidoEntity other = (PedidoEntity) obj;
		
		if (idPedido == null) {
			
			if (other.idPedido != null)
				return false;
			
		} else if (!idPedido.equals(other.idPedido)) {
			
			return false;
			
		}
		
		return true;
	}

}
