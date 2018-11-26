package com.aula.udemy.cursoudemy.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.aula.udemy.cursoudemy.dtos.CategoriaDTO;

@Entity(name="TBL_CATEGORIA")
public class CategoriaEntity implements Serializable{

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CATEGORIA")
	private Integer idCategoria;

	@Column(name="DS_NOME")
	private String nome;
	
	@ManyToMany(mappedBy="listaCategorias")
	private List<ProdutosEntity> listaProdutos = new ArrayList<>();

	public CategoriaEntity() {
	}

	public CategoriaEntity(Integer idCategoria, String nome) {
		this.idCategoria = idCategoria;
		this.nome = nome;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
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

		CategoriaEntity other = (CategoriaEntity) obj;

		if (idCategoria == null) {
			
			if (other.idCategoria != null)
				return false;
			
		} else if (!idCategoria.equals(other.idCategoria)) {
			
			return false;
			
		}
		
		return true;
	}
	
	public CategoriaDTO dePara() {
		
		CategoriaDTO categoria = new CategoriaDTO();
		
		categoria.setIdCategoria(this.getIdCategoria());
		categoria.setNome(this.getNome());
		categoria.setListaProdutos(this.getListaProdutos());
		
		return categoria;
	}

}
