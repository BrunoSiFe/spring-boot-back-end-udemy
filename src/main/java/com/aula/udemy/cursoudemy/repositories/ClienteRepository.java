package com.aula.udemy.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.udemy.cursoudemy.entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

}
