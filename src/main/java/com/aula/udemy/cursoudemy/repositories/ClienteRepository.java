package com.aula.udemy.cursoudemy.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.udemy.cursoudemy.entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

	@Transactional
	ClienteEntity findByEmail(String email);
	
}
