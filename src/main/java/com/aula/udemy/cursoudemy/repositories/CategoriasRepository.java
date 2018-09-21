package com.aula.udemy.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.udemy.cursoudemy.entities.CategoriaEntity;

@Repository
public interface CategoriasRepository extends JpaRepository<CategoriaEntity, Integer>{

}
