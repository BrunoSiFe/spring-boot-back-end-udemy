package com.aula.udemy.cursoudemy.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.aula.udemy.cursoudemy.entities.CategoriaEntity;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idCategoria;
	
	@NotEmpty(message="O Campo é Obrigatório.")
	@Length(min=5,max=80,message="O campo deve ter entre 5 e 80 caracteres.")
	private String nome;

	public CategoriaDTO() {}
	
	public CategoriaDTO(CategoriaEntity categoria) {
		this.idCategoria = categoria.getIdCategoria();
		this.nome = categoria.getNome();
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

}
