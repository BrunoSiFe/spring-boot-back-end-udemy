package com.aula.udemy.cursoudemy.services.validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aula.udemy.cursoudemy.constants.enums.TipoClienteEnum;
import com.aula.udemy.cursoudemy.controller.exceptions.dto.FieldMessages;
import com.aula.udemy.cursoudemy.dtos.ClienteNewDTO;
import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.repositories.ClienteRepository;
import com.aula.udemy.cursoudemy.services.annotations.ClienteInsert;
import com.aula.udemy.cursoudemy.utils.CpfCnpjValidadorUtils;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public boolean isValid(ClienteNewDTO clienteDTO, ConstraintValidatorContext context) {
		List<FieldMessages> list = new ArrayList<>();

		if (clienteDTO.getTipoCliente().equals(TipoClienteEnum.PESSOA_FISICA.getCodigoTipoCliente())
				&& !(CpfCnpjValidadorUtils.isValidCPF(clienteDTO.getCpfCnpj())))
			list.add(new FieldMessages("CpfCnpj", "Cpf Inválido."));

		if (clienteDTO.getTipoCliente().equals(TipoClienteEnum.PESSOA_JURIDICA.getCodigoTipoCliente())
				&& !(CpfCnpjValidadorUtils.isValidCNPJ(clienteDTO.getCpfCnpj())))
			list.add(new FieldMessages("CpfCnpj", "Cnpj Inválido."));
		
		ClienteEntity clienteAuxiliar = clienteRepository.findByEmail(clienteDTO.getEmail());
		
		if(clienteAuxiliar != null)
			list.add(new FieldMessages("email", "Email já cadastrado."));

		for (FieldMessages e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
