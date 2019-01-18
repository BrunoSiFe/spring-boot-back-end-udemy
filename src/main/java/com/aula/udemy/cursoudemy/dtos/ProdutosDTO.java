package com.aula.udemy.cursoudemy.dtos;

import java.io.Serializable;

import com.aula.udemy.cursoudemy.entities.ProdutosEntity;

public class ProdutosDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idProduto;
	
	private String nomeProduto;
	
	private Double precoProduto;
		
	public ProdutosDTO() {
		super();
	}
	
	public ProdutosDTO(ProdutosEntity produtosEntity) {
		this.nomeProduto = produtosEntity.getNomeProduto();
		this.precoProduto = produtosEntity.getPrecoProduto();
		this.idProduto = produtosEntity.getIdProduto();
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
	
}
