package com.aula.udemy.cursoudemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aula.udemy.cursoudemy.entities.CategoriaEntity;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

	
	@RequestMapping(method=RequestMethod.GET)
	public List<CategoriaEntity> listar() {
		
		CategoriaEntity cat1 = new CategoriaEntity(1,"Informática");
		CategoriaEntity cat2 = new CategoriaEntity(2,"Calçados");
		
		List<CategoriaEntity> listaCategorias = new ArrayList<>();
		listaCategorias.add(cat1);
		listaCategorias.add(cat2);
		
		return listaCategorias;
		
	}
}
