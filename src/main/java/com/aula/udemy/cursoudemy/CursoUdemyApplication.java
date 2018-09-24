package com.aula.udemy.cursoudemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aula.udemy.cursoudemy.constants.enums.TipoClienteEnum;
import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.entities.CidadeEntity;
import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.entities.EnderecoEntity;
import com.aula.udemy.cursoudemy.entities.EstadoEntity;
import com.aula.udemy.cursoudemy.entities.ProdutosEntity;
import com.aula.udemy.cursoudemy.repositories.CategoriasRepository;
import com.aula.udemy.cursoudemy.repositories.CidadeRepository;
import com.aula.udemy.cursoudemy.repositories.ClienteRepository;
import com.aula.udemy.cursoudemy.repositories.EnderecoRepository;
import com.aula.udemy.cursoudemy.repositories.EstadoRepository;
import com.aula.udemy.cursoudemy.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUdemyApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriasRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoriaEntity informatica = new CategoriaEntity(null, "Informática");
		CategoriaEntity escritorio = new CategoriaEntity(null, "Escritório");
		
		List<CategoriaEntity> listaCategoriasInstanciadas = new ArrayList<>();
		
		ProdutosEntity computador = new ProdutosEntity(null,"Computador",2000.00);
		ProdutosEntity mouse = new ProdutosEntity(null,"Mouse",100.00);
		ProdutosEntity impressora = new ProdutosEntity(null,"Impressora",700.00);
		
		List<ProdutosEntity> listaProdutos = new ArrayList<>();
		
		EstadoEntity minasGerais = new EstadoEntity(null,"Minas Gerais");
		EstadoEntity saoPaulo = new EstadoEntity(null,"São Paulo");
		
		List<EstadoEntity> listaEstados = new ArrayList<>();
		
		listaEstados.add(minasGerais);
		listaEstados.add(saoPaulo);
		
		CidadeEntity uberlandia = new CidadeEntity(null,"Uberlândia",minasGerais);
		CidadeEntity saoPauloCidade = new CidadeEntity(null,"São Paulo",saoPaulo);
		CidadeEntity campinas = new CidadeEntity(null,"Campinas", saoPaulo);
		
		List<CidadeEntity> listaCidades = new ArrayList<>();
		
		ClienteEntity mariaSilva = new ClienteEntity(null,"Maria Silva","maria@gmail.com","36378912377",TipoClienteEnum.PESSOA_FISICA);
		
		mariaSilva.getListaTelefones().addAll(Arrays.asList("3134275882","3134413517"));
		
		List<ClienteEntity> listaClientes = new ArrayList<>();
		
		listaClientes.add(mariaSilva);
		
		EnderecoEntity ruaFlores = new EnderecoEntity(null,"Rua Flores","300","Apto 302","Jardim","31710560",mariaSilva,uberlandia);
		EnderecoEntity avenidaMatos = new EnderecoEntity(null,"Avenida Matos","105","Sala 800","Centro","31710580",mariaSilva,saoPauloCidade);
		
		List<EnderecoEntity> listaEnderecos = new ArrayList<>();
		
		listaEnderecos.add(ruaFlores);
		listaEnderecos.add(avenidaMatos);
		
		listaCidades.add(uberlandia);
		listaCidades.add(saoPauloCidade);
		listaCidades.add(campinas);
		
		listaProdutos.add(computador);
		listaProdutos.add(mouse);
		listaProdutos.add(impressora);
		
		listaCategoriasInstanciadas.add(informatica);
		listaCategoriasInstanciadas.add(escritorio);
		
		informatica.getListaProdutos().addAll(Arrays.asList(computador,mouse,impressora));
		escritorio.getListaProdutos().add(impressora);
		
		computador.getListaCategorias().add(informatica);
		mouse.getListaCategorias().add(informatica);
		impressora.getListaCategorias().addAll(Arrays.asList(informatica,escritorio));
		
		categoriaRepository.saveAll(listaCategoriasInstanciadas);

		produtoRepository.saveAll(listaProdutos);
		
		estadoRepository.saveAll(listaEstados);
		
		cidadeRepository.saveAll(listaCidades);
		
		clienteRepository.saveAll(listaClientes);
		
		enderecoRepository.saveAll(listaEnderecos);		
	}
}
