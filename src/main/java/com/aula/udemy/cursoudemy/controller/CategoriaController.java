package com.aula.udemy.cursoudemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aula.udemy.cursoudemy.dtos.CategoriaDTO;
import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value= "/{idCategoria}",method=RequestMethod.GET)
	public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Integer idCategoria) {
		
		CategoriaEntity categoriaEntity = categoriaService.buscarCategoriaPorId(idCategoria);
		
		CategoriaDTO categoria = categoriaEntity.dePara(categoriaEntity);
		
		return ResponseEntity.ok(categoria);
		
	}
}
