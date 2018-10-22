package com.aula.udemy.cursoudemy.constants.enums;

public enum EstadoPagamentoEnum {

	PENDENTE(1, "PENDENTE"),
	QUITADO(2, "QUITADO"),
	CANCELADO(3 ,"CANCELADO");	
	
	private Integer codigoEstadoPagamento;
	
	private String dsEstadoPagamento;
	
	private EstadoPagamentoEnum(Integer codigoEstadoPagamento, String dsEstadoPagamento) {
		this.codigoEstadoPagamento = codigoEstadoPagamento;
		this.dsEstadoPagamento = dsEstadoPagamento;
	}

	public Integer getCodigoEstadoPagamento() {
		return codigoEstadoPagamento;
	}

	public String getDsEstadoPagamento() {
		return dsEstadoPagamento;
	}

	public static EstadoPagamentoEnum toEnum(Integer codigoEstadoPagamento) {

		if (codigoEstadoPagamento == null)
			return null;

		for (EstadoPagamentoEnum estadoPagamento : EstadoPagamentoEnum.values()) {
			if (codigoEstadoPagamento.equals(estadoPagamento.codigoEstadoPagamento)) {
				return estadoPagamento;
			}
		}

		throw new IllegalArgumentException("Coódigo para o estado Da Transação Não Encontrado : " + codigoEstadoPagamento);
	}
}
