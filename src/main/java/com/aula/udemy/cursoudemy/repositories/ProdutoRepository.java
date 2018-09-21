package com.aula.udemy.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.udemy.cursoudemy.entities.ProdutosEntity;

public interface ProdutoRepository extends JpaRepository<ProdutosEntity, Integer>{

}
