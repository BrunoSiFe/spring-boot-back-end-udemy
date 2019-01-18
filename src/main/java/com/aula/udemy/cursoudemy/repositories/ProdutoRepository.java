package com.aula.udemy.cursoudemy.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.entities.ProdutosEntity;

public interface ProdutoRepository extends JpaRepository<ProdutosEntity, Integer>{
	
	@Transactional
	@Query("SELECT DISTINCT produto FROM TBL_PRODUTO produto INNER JOIN produto.listaCategorias categoria "
			+ " WHERE produto.nome LIKE %:nome% AND categoria IN :categorias")
	Page<ProdutosEntity> pesquisarProdutos(@Param("nome")String nome, @Param("categorias")List<CategoriaEntity> categorias, Pageable pageRequest);

}
