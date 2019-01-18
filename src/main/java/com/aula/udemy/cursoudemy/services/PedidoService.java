package com.aula.udemy.cursoudemy.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.constants.enums.EstadoPagamentoEnum;
import com.aula.udemy.cursoudemy.entities.ItemPedidoEntity;
import com.aula.udemy.cursoudemy.entities.PagamentoComBoletoEntity;
import com.aula.udemy.cursoudemy.entities.PedidoEntity;
import com.aula.udemy.cursoudemy.exceptions.ObjectNotFoundException;
import com.aula.udemy.cursoudemy.repositories.ItemPedidoRepository;
import com.aula.udemy.cursoudemy.repositories.PagamentoRepository;
import com.aula.udemy.cursoudemy.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtosService;

	public PedidoEntity buscarCategoriaPorId(Integer idPedido) {
		
		Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(idPedido);
		
		return pedidoEntity.orElseThrow(() -> 
					new ObjectNotFoundException("Objeto não encontrado! Id: " + idPedido + ", Tipo: " + PedidoEntity.class.getName())); 
	}
	
	@Transactional
	public PedidoEntity inserirPedido(PedidoEntity pedidoEntity) {
		pedidoEntity.setIdPedido(null);
		pedidoEntity.setDataPedido(new Date());
		pedidoEntity.setCliente(clienteService.buscarClientePorId(pedidoEntity.getCliente().getIdCliente()));
		pedidoEntity.getPagamento().setEstado(EstadoPagamentoEnum.PENDENTE);
		pedidoEntity.getPagamento().setPedido(pedidoEntity);
		
		if(pedidoEntity.getPagamento() instanceof PagamentoComBoletoEntity) {
			PagamentoComBoletoEntity pagamentoEntity = (PagamentoComBoletoEntity) pedidoEntity.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagamentoEntity, pedidoEntity.getDataPedido());
		}
		
		pedidoEntity = pedidoRepository.save(pedidoEntity);
		pagamentoRepository.save(pedidoEntity.getPagamento());
		
		for(ItemPedidoEntity itemPedido : pedidoEntity.getItens()) {
			itemPedido.setVlDesconto(0.0);
			itemPedido.setProduto(produtosService.buscarProdutoPorId(itemPedido.getProduto().getIdProduto()));
			itemPedido.setVlPreco(itemPedido.getProduto().getPrecoProduto());
			itemPedido.setPedido(pedidoEntity);
		}
		System.out.println(pedidoEntity);
		itemPedidoRepository.saveAll(pedidoEntity.getItens());
		return pedidoEntity;
	}
	
}
