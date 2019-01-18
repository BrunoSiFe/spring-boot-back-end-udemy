package com.aula.udemy.cursoudemy.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.constants.enums.EstadoPagamentoEnum;
import com.aula.udemy.cursoudemy.constants.enums.TipoClienteEnum;
import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.entities.CidadeEntity;
import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.entities.EnderecoEntity;
import com.aula.udemy.cursoudemy.entities.EstadoEntity;
import com.aula.udemy.cursoudemy.entities.ItemPedidoEntity;
import com.aula.udemy.cursoudemy.entities.PagamentoComBoletoEntity;
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

@Service
public class DBService {
	
	
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

	public void intanciarBanco() throws ParseException {
		
		CategoriaEntity cat1 = new CategoriaEntity(null, "Informática");
		CategoriaEntity cat2 = new CategoriaEntity(null, "Escritório");
		CategoriaEntity cat3 = new CategoriaEntity(null, "Cama mesa e banho");
		CategoriaEntity cat4 = new CategoriaEntity(null, "Eletrônicos");
		CategoriaEntity cat5 = new CategoriaEntity(null, "Jardinagem");
		CategoriaEntity cat6 = new CategoriaEntity(null, "Decoração");
		CategoriaEntity cat7 = new CategoriaEntity(null, "Perfumaria");
		
		ProdutosEntity p1 = new ProdutosEntity(null, "Computador", 2000.00);
		ProdutosEntity p2 = new ProdutosEntity(null, "Impressora", 800.00);
		ProdutosEntity p3 = new ProdutosEntity(null, "Mouse", 80.00);
		ProdutosEntity p4 = new ProdutosEntity(null, "Mesa de escritório", 300.00);
		ProdutosEntity p5 = new ProdutosEntity(null, "Toalha", 50.00);
		ProdutosEntity p6 = new ProdutosEntity(null, "Colcha", 200.00);
		ProdutosEntity p7 = new ProdutosEntity(null, "TV true color", 1200.00);
		ProdutosEntity p8 = new ProdutosEntity(null, "Roçadeira", 800.00);
		ProdutosEntity p9 = new ProdutosEntity(null, "Abajour", 100.00);
		ProdutosEntity p10 = new ProdutosEntity(null, "Pendente", 180.00);
		ProdutosEntity p11 = new ProdutosEntity(null, "Shampoo", 90.00);
		
		cat1.getListaProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getListaProdutos().addAll(Arrays.asList(p2));
		
		p1.getListaCategorias().addAll(Arrays.asList(cat1));
		p2.getListaCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getListaCategorias().addAll(Arrays.asList(cat1));
		cat2.getListaProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getListaProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getListaProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getListaProdutos().addAll(Arrays.asList(p8));
		cat6.getListaProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getListaProdutos().addAll(Arrays.asList(p11));
		
		p1.getListaCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getListaCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getListaCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getListaCategorias().addAll(Arrays.asList(cat2));
		p5.getListaCategorias().addAll(Arrays.asList(cat3));
		p6.getListaCategorias().addAll(Arrays.asList(cat3));
		p7.getListaCategorias().addAll(Arrays.asList(cat4));
		p8.getListaCategorias().addAll(Arrays.asList(cat5));
		p9.getListaCategorias().addAll(Arrays.asList(cat6));
		p10.getListaCategorias().addAll(Arrays.asList(cat6));
		p11.getListaCategorias().addAll(Arrays.asList(cat7));		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		EstadoEntity est1 = new EstadoEntity(null, "Minas Gerais");
		EstadoEntity est2 = new EstadoEntity(null, "São Paulo");
		
		CidadeEntity c1 = new CidadeEntity(null, "Uberlândia", est1);
		CidadeEntity c2 = new CidadeEntity(null, "São Paulo", est2);
		CidadeEntity c3 = new CidadeEntity(null, "Campinas", est2);
		
		est1.getListaCidades().addAll(Arrays.asList(c1));
		est2.getListaCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		ClienteEntity cli1 = new ClienteEntity(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoClienteEnum.PESSOA_FISICA);
		
		cli1.getListaTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		EnderecoEntity e1 = new EnderecoEntity(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		EnderecoEntity e2 = new EnderecoEntity(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getListaEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		PedidoEntity ped1 = new PedidoEntity(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		PedidoEntity ped2 = new PedidoEntity(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		PagamentoEntity pagto1 = new PagamentoComCartaoEntity(null, EstadoPagamentoEnum.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		PagamentoEntity pagto2 = new PagamentoComBoletoEntity(null, EstadoPagamentoEnum.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
				
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedidoEntity ip1 = new ItemPedidoEntity(ped1, p1, 0.00, 1, 2000.00);
		ItemPedidoEntity ip2 = new ItemPedidoEntity(ped1, p3, 0.00, 2, 80.00);
		ItemPedidoEntity ip3 = new ItemPedidoEntity(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));	
	}
	
}
