package com.aula.udemy.cursoudemy.dtos;

import java.util.ArrayList;
import java.util.List;

import com.aula.udemy.cursoudemy.entities.ProdutosEntity;

public class CategoriaDTO {

	private Integer idCategoria;

	private String nome;
	
	private List<ProdutosEntity> listaProdutos = new ArrayList<>();

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProdutosEntity> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ProdutosEntity> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
