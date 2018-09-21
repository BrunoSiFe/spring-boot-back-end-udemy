package com.aula.udemy.cursoudemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.entities.ProdutosEntity;
import com.aula.udemy.cursoudemy.repositories.CategoriasRepository;
import com.aula.udemy.cursoudemy.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUdemyApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriasRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoriaEntity informatica = new CategoriaEntity(null, "Informática");
		CategoriaEntity escritorio = new CategoriaEntity(null, "Escritório");
		
		List<CategoriaEntity> listaCategoriasInstanciadas = new ArrayList<>();
		
		listaCategoriasInstanciadas.add(informatica);
		listaCategoriasInstanciadas.add(escritorio);
		
		ProdutosEntity computador = new ProdutosEntity(null,"Computador",2000.00);
		ProdutosEntity mouse = new ProdutosEntity(null,"Mouse",100.00);
		ProdutosEntity impressora = new ProdutosEntity(null,"Impressora",700.00);
		
		List<ProdutosEntity> listaProdutos = new ArrayList<>();
		
		listaProdutos.add(computador);
		listaProdutos.add(mouse);
		listaProdutos.add(impressora);
		
		informatica.getListaProdutos().addAll(Arrays.asList(computador,mouse,impressora));
		escritorio.getListaProdutos().add(impressora);
		
		computador.getListaCategorias().add(informatica);
		mouse.getListaCategorias().add(informatica);
		impressora.getListaCategorias().addAll(Arrays.asList(informatica,escritorio));
		
		categoriaRepository.saveAll(listaCategoriasInstanciadas);

		produtoRepository.saveAll(listaProdutos);
		
		
	}
}
