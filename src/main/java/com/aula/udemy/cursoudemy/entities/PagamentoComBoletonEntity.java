package com.aula.udemy.cursoudemy.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.aula.udemy.cursoudemy.constants.enums.EstadoPagamentoEnum;

@Entity(name="TBL_PAGAMENTO_BOLETO")
public class PagamentoComBoletonEntity extends PagamentoEntity{

	private static final long serialVersionUID = 1L;

	@Column(name="DT_VENCIMENTO")
	private Date dtVencimento;
	
	@Column(name="DT_PAGAMENTO")
	private Date dtPagamento;
	
	public PagamentoComBoletonEntity() {}

	public PagamentoComBoletonEntity(Integer idProduto, EstadoPagamentoEnum estado, PedidoEntity pedido,Date dtVencimento, Date dtPagamento) {
		super(idProduto, estado, pedido);
		this.dtPagamento = dtPagamento;
		this.dtVencimento = dtVencimento;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	
}
