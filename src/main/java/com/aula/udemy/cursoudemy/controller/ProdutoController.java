package com.aula.udemy.cursoudemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aula.udemy.cursoudemy.controller.utils.URL;
import com.aula.udemy.cursoudemy.dtos.ProdutosDTO;
import com.aula.udemy.cursoudemy.entities.ProdutosEntity;
import com.aula.udemy.cursoudemy.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value= "/{idProduto}",method=RequestMethod.GET)
	public ResponseEntity<ProdutosEntity> buscarProdutoPorId(@PathVariable Integer idProduto) {
		
		ProdutosEntity produtoEntity = produtoService.buscarProdutoPorId(idProduto);
		
		return ResponseEntity.ok(produtoEntity);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutosDTO>> listarCategoriasInPages(
			@RequestParam(value="nomePesquisado",defaultValue="") String nomePesquisado, 
			@RequestParam(value="idCategorias",defaultValue="") String idCategorias, 
			@RequestParam(value="page",defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage",defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy",defaultValue="nome") String orderBy, 
			@RequestParam(value="direction",defaultValue="ASC") String direction){
		Page<ProdutosEntity> listaProdutos = produtoService.pesquisarProdutos(URL.decodeParam(nomePesquisado), URL.decodeIntList(idCategorias),page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(listaProdutos.map(produto -> new ProdutosDTO(produto)));
	}
}
