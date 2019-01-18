package com.aula.udemy.cursoudemy.services.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.aula.udemy.cursoudemy.controller.exceptions.dto.FieldMessages;
import com.aula.udemy.cursoudemy.dtos.ClienteDTO;
import com.aula.udemy.cursoudemy.entities.ClienteEntity;
import com.aula.udemy.cursoudemy.repositories.ClienteRepository;
import com.aula.udemy.cursoudemy.services.annotations.ClienteUpdate;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public boolean isValid(ClienteDTO clienteDTO, ConstraintValidatorContext context) {
		List<FieldMessages> list = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Map<String, String> map =(Map<String,String>) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);		
		ClienteEntity clienteAuxiliar = clienteRepository.findByEmail(clienteDTO.getEmail());
		
		if(clienteAuxiliar != null && (clienteAuxiliar.getIdCliente() == Integer.parseInt(map.get("id"))))
			list.add(new FieldMessages("email", "Email já cadastrado."));

		for (FieldMessages e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
