package com.aula.udemy.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.repositories.CategoriasRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriasRepository categoriaRepository;

	public CategoriaEntity buscarCategoriaPorId(Integer idCategoria) {
		
		Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(idCategoria);
		
		return categoriaEntity.orElse(null);
	}
	
}
