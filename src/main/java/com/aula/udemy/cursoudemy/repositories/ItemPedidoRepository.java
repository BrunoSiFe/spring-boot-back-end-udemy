package com.aula.udemy.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.udemy.cursoudemy.entities.ItemPedidoEntity;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Integer>{

}
