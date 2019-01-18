package com.aula.udemy.cursoudemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.entities.ProdutosEntity;
import com.aula.udemy.cursoudemy.exceptions.ObjectNotFoundException;
import com.aula.udemy.cursoudemy.repositories.CategoriasRepository;
import com.aula.udemy.cursoudemy.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriasRepository categoriaRepository;

	public ProdutosEntity buscarProdutoPorId(Integer idProduto) {
		
		Optional<ProdutosEntity> produtoEntity = produtoRepository.findById(idProduto);
		
		return produtoEntity.orElseThrow(() -> 
					new ObjectNotFoundException("Objeto não encontrado! Id: " + idProduto + ", Tipo: " + ProdutosEntity.class.getName())); 
	}
	
	public Page<ProdutosEntity> pesquisarProdutos(String nomePesquisado, List<Integer> idCategorias,Integer page,Integer linesPerPage,String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<CategoriaEntity> categorias = categoriaRepository.findAllById(idCategorias);
		return produtoRepository.pesquisarProdutos(nomePesquisado,categorias,pageRequest);
	}
	
}
