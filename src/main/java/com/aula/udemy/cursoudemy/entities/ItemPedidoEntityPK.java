package com.aula.udemy.cursoudemy.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class ItemPedidoEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="id_pedido")
	private PedidoEntity pedido;

	@ManyToOne
	@JoinColumn(name="id_produto")
	private ProdutosEntity produto;

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public ProdutosEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutosEntity produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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

		ItemPedidoEntityPK other = (ItemPedidoEntityPK) obj;

		if (pedido == null) {

			if (other.pedido != null)
				return false;

		} else if (!pedido.equals(other.pedido)) {

			return false;
			
		}
		
		if (produto == null) {

			if (other.produto != null)
				return false;

		} else if (!produto.equals(other.produto)) {
			
			return false;
			
		}
		
		return true;
	}

}
