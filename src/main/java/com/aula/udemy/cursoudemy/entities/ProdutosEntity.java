package com.aula.udemy.cursoudemy.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="TBL_PRODUTO")
public class ProdutosEntity implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRODUTO")
	private Integer idProduto;
	
	@Column(name="DS_NOME_PRODUTO")
	private String nomeProduto;
	
	@Column(name="VL_PRECO_PRODUTO")
	private Double precoProduto;
	
	@ManyToMany
	@JoinTable(name = "TBL_PRODUTO_CATEGORIA",
			joinColumns = @JoinColumn(name="id_produto"),
			inverseJoinColumns = @JoinColumn(name="id_categoria"))
	@JsonIgnore
	private List<CategoriaEntity> listaCategorias = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemPedidoEntity> itens = new HashSet<>();

	public ProdutosEntity() {}
	
	public ProdutosEntity(Integer idProduto, String nomeProduto, Double precoProduto) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
	}
	
	@JsonIgnore
	public List<PedidoEntity> getPedidos(){
		List<PedidoEntity> listaPedidos = new ArrayList<>();
		for(ItemPedidoEntity itemPedido : itens) {
			listaPedidos.add(itemPedido.getPedido());
		}
		return listaPedidos;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public List<CategoriaEntity> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaEntity> listaCategorias) {
		this.listaCategorias = listaCategorias;
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
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
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
		
		ProdutosEntity other = (ProdutosEntity) obj;
		
		if (idProduto == null) {
			
			if (other.idProduto != null)
				return false;
			
		} else if (!idProduto.equals(other.idProduto)) {
			
			return false;
			
		}
		
		return true;
	}
	
}
