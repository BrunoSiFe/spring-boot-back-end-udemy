package com.aula.udemy.cursoudemy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.aula.udemy.cursoudemy.constants.enums.EstadoPagamentoEnum;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity(name="TBL_PAGAMENTO_CARTAO")
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartaoEntity extends PagamentoEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="NR_PARCELAS")
	private Integer nrParcelas;

	public PagamentoComCartaoEntity() {
	}

	public PagamentoComCartaoEntity(Integer idProduto, EstadoPagamentoEnum estado, PedidoEntity pedido,Integer nrParcelas) {
		super(idProduto, estado, pedido);
		this.nrParcelas = nrParcelas;
	}

	public Integer getNrParcelas() {
		return nrParcelas;
	}

	public void setNrParcelas(Integer nrParcelas) {
		this.nrParcelas = nrParcelas;
	}
	
}
