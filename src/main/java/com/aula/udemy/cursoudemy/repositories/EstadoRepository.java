package com.aula.udemy.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.udemy.cursoudemy.entities.EstadoEntity;

public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer>{

}
