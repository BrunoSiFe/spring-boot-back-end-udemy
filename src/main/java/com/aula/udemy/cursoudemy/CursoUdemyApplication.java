package com.aula.udemy.cursoudemy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aula.udemy.cursoudemy.constants.enums.EstadoPagamentoEnum;
import com.aula.udemy.cursoudemy.constants.enums.TipoClienteEnum;
import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.entities.CidadeEntity;
import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.entities.EnderecoEntity;
import com.aula.udemy.cursoudemy.entities.EstadoEntity;
import com.aula.udemy.cursoudemy.entities.ItemPedidoEntity;
import com.aula.udemy.cursoudemy.entities.PagamentoComBoletonEntity;
import com.aula.udemy.cursoudemy.entities.PagamentoComCartaoEntity;
import com.aula.udemy.cursoudemy.entities.PagamentoEntity;
import com.aula.udemy.cursoudemy.entities.PedidoEntity;
import com.aula.udemy.cursoudemy.entities.ProdutosEntity;
import com.aula.udemy.cursoudemy.repositories.CategoriasRepository;
import com.aula.udemy.cursoudemy.repositories.CidadeRepository;
import com.aula.udemy.cursoudemy.repositories.ClienteRepository;
import com.aula.udemy.cursoudemy.repositories.EnderecoRepository;
import com.aula.udemy.cursoudemy.repositories.EstadoRepository;
import com.aula.udemy.cursoudemy.repositories.ItemPedidoRepository;
import com.aula.udemy.cursoudemy.repositories.PagamentoRepository;
import com.aula.udemy.cursoudemy.repositories.PedidoRepository;
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
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoUdemyApplication.class, args);
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		CategoriaEntity informatica = new CategoriaEntity(null, "Informática");
		CategoriaEntity escritorio = new CategoriaEntity(null, "Escritório");
		CategoriaEntity camaMesaBanho = new CategoriaEntity(null, "Cama,Mesa e Banho");
		CategoriaEntity higiene = new CategoriaEntity(null, "Higiene");
		CategoriaEntity roupas = new CategoriaEntity(null, "Roupas");
		CategoriaEntity casa = new CategoriaEntity(null, "Casa");
		CategoriaEntity eletronicos = new CategoriaEntity(null, "Eletrônicos");
		CategoriaEntity escolar = new CategoriaEntity(null, "Escolar");
		CategoriaEntity alimentos = new CategoriaEntity(null, "Alimentos");
		CategoriaEntity acougue = new CategoriaEntity(null, "Açougue");
		
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
		
		PedidoEntity primeiroPedido = new PedidoEntity(null,formatter.parse("30/09/2017 10:32"),mariaSilva,ruaFlores);
		PedidoEntity segundoPedido = new PedidoEntity(null,formatter.parse("10/10/2017 19:35"),mariaSilva,avenidaMatos);
		
		PagamentoEntity pagamentoPedidoUm = new PagamentoComCartaoEntity(null, EstadoPagamentoEnum.QUITADO, primeiroPedido, 6);
		primeiroPedido.setPagamento(pagamentoPedidoUm);
		
		PagamentoEntity segundoPagamento = new PagamentoComBoletonEntity(null, EstadoPagamentoEnum.PENDENTE,segundoPedido,formatter.parse("20/10/2017 00:00"),null);
		segundoPedido.setPagamento(segundoPagamento);
		
		ItemPedidoEntity itemPedidoComputador = new ItemPedidoEntity(primeiroPedido,mouse,0.00,1,2000.00);
		ItemPedidoEntity itemPedidoImpressora = new ItemPedidoEntity(primeiroPedido,computador,0.00,2,80.00);
		ItemPedidoEntity itemPedidoMouse = new ItemPedidoEntity(segundoPedido,impressora  ,100.00,1,800.00);
		
		primeiroPedido.getItens().addAll(Arrays.asList(itemPedidoComputador,itemPedidoImpressora));
		segundoPedido.getItens().addAll(Arrays.asList(itemPedidoMouse));
		
		computador.getItens().addAll(Arrays.asList(itemPedidoComputador));
		impressora.getItens().addAll(Arrays.asList(itemPedidoImpressora));
		mouse.getItens().addAll(Arrays.asList(itemPedidoMouse));
		
		mariaSilva.getPedidos().addAll(Arrays.asList(primeiroPedido,segundoPedido));
		
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
		listaCategoriasInstanciadas.add(camaMesaBanho);
		listaCategoriasInstanciadas.add(higiene);
		listaCategoriasInstanciadas.add(roupas);
		listaCategoriasInstanciadas.add(casa);
		listaCategoriasInstanciadas.add(eletronicos);
		listaCategoriasInstanciadas.add(escolar);
		listaCategoriasInstanciadas.add(alimentos);
		listaCategoriasInstanciadas.add(acougue);
		
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
		
		pedidoRepository.saveAll(Arrays.asList(primeiroPedido,segundoPedido));
		
		pagamentoRepository.saveAll(Arrays.asList(pagamentoPedidoUm,segundoPagamento));
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedidoComputador,itemPedidoImpressora,itemPedidoMouse));
		
	}
}
