package com.aula.udemy.cursoudemy.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="TBL_ITEM_PEDIDO")
public class ItemPedidoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoEntityPK id = new ItemPedidoEntityPK();

	@Column(name="VL_DESCONTO")
	private Double vlDesconto;

	@Column(name="QTD_COMPRADA")
	private Integer qtdComprada;

	@Column(name="VL_PRECO")
	private Double vlPreco;

	public ItemPedidoEntity(PedidoEntity pedido, ProdutosEntity produto, Double vlDesconto, Integer qtdComprada,
			Double vlPreco) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.vlDesconto = vlDesconto;
		this.qtdComprada = qtdComprada;
		this.vlPreco = vlPreco;
	}

	public ItemPedidoEntity() {

	}

	public ItemPedidoEntityPK getId() {
		return id;
	}

	public void setId(ItemPedidoEntityPK id) {
		this.id = id;
	}

	public Double getVlDesconto() {
		return vlDesconto;
	}

	public void setVlDesconto(Double vlDesconto) {
		this.vlDesconto = vlDesconto;
	}

	public Integer getQtdComprada() {
		return qtdComprada;
	}

	public void setQtdComprada(Integer qtdComprada) {
		this.qtdComprada = qtdComprada;
	}

	public Double getVlPreco() {
		return vlPreco;
	}

	public void setVlPreco(Double vlPreco) {
		this.vlPreco = vlPreco;
	}

	@JsonIgnore
	public PedidoEntity getPedido() {
		return this.getPedido();
	}

	public ProdutosEntity getProduto() {
		return this.id.getProduto();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItemPedidoEntity other = (ItemPedidoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
