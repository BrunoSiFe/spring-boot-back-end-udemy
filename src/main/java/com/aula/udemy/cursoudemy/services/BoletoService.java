package com.aula.udemy.cursoudemy.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.entities.PagamentoComBoletoEntity;

@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoletoEntity pagamentoBoleto ,Date dataPedido) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataPedido);
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		pagamentoBoleto.setDtVencimento(calendar.getTime());
	}

}
