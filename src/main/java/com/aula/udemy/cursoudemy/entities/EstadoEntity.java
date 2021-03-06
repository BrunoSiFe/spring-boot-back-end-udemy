package com.aula.udemy.cursoudemy.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="TBL_ESTADO")
public class EstadoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado")
	private Integer id;

	@Column(name="ds_nome")
	private String nome;

	@OneToMany(mappedBy="estado")
	@JsonIgnore	
	private List<CidadeEntity> listaCidades = new ArrayList<>();

	public EstadoEntity() {
	}

	public EstadoEntity(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CidadeEntity> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<CidadeEntity> listaCidades) {
		this.listaCidades = listaCidades;
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

		EstadoEntity other = (EstadoEntity) obj;
		if (id == null) {

			if (other.id != null)
				return false;

		} else if (!id.equals(other.id)) {
			
			return false;
			
		}
		
		return true;
	}

}
