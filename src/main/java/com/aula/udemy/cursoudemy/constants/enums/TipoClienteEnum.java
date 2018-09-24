package com.aula.udemy.cursoudemy.constants.enums;

public enum TipoClienteEnum {

	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");

	private Integer codigoTipoCliente;

	private String descricaoTipoCliente;

	private TipoClienteEnum(int codigoTipoCliente, String descricaoTipoCliente) {
		this.codigoTipoCliente = codigoTipoCliente;
		this.descricaoTipoCliente = descricaoTipoCliente;
	}

	public int getCodigoTipoCliente() {
		return codigoTipoCliente;
	}

	public String getDescricaoTipoCliente() {
		return descricaoTipoCliente;
	}

	public static TipoClienteEnum toEnum(Integer codigoTipoCliente) {

		if (codigoTipoCliente == null)
			return null;

		for (TipoClienteEnum tipoCliente : TipoClienteEnum.values()) {
			if (codigoTipoCliente.equals(tipoCliente.codigoTipoCliente)) {
				return tipoCliente;
			}
		}

		throw new IllegalArgumentException("Id para o tipo de pessoa não encontrado : " + codigoTipoCliente);
	}
}
