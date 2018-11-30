package com.aula.udemy.cursoudemy.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aula.udemy.cursoudemy.dtos.CategoriaDTO;
import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = "/{idCategoria}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaEntity> buscarCategoriaPorId(@PathVariable Integer idCategoria) {

		CategoriaEntity categoriaEntity = categoriaService.buscarCategoriaPorId(idCategoria);

		return ResponseEntity.ok(categoriaEntity);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserirCategoria(@RequestBody @Valid CategoriaDTO categoria) {

		CategoriaEntity categoriaInserida = categoriaService.inserirCategoria(categoria);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCategoria}")
				.buildAndExpand(categoriaInserida.getIdCategoria()).toUri();
		
		return ResponseEntity.created(uri).build();

	}
	
	@RequestMapping(value = "/{idCategoria}", method = RequestMethod.PATCH)
	public ResponseEntity<CategoriaEntity> atualizarCategoria(@RequestBody  @Valid CategoriaDTO categoria,@PathVariable Integer idCategoria) {
		
		categoria.setIdCategoria(idCategoria);
		categoriaService.atualizarCategoria(categoria);

		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value = "/{idCategoria}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarCategoria(@PathVariable Integer idCategoria) {

		categoriaService.deletarCategoria(idCategoria);

		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> listarCategorias(){
		List<CategoriaEntity> listaCategorias = categoriaService.listarCategorias();
		return ResponseEntity.ok().body(listaCategorias.stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList()));
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> listarCategoriasInPages(
			@RequestParam(value="page",defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage",defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy",defaultValue="nome") String orderBy, 
			@RequestParam(value="direction",defaultValue="ASC") String direction){
		Page<CategoriaEntity> listaCategorias = categoriaService.findAllInPages(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(listaCategorias.map(categoria -> new CategoriaDTO(categoria)));
	}
}
