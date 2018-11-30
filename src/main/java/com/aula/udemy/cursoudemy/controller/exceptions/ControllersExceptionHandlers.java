package com.aula.udemy.cursoudemy.controller.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aula.udemy.cursoudemy.controller.exceptions.dto.StandartErrorDTO;
import com.aula.udemy.cursoudemy.controller.exceptions.dto.ValidationError;
import com.aula.udemy.cursoudemy.exceptions.DataIntegrityException;
import com.aula.udemy.cursoudemy.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControllersExceptionHandlers {
	
	private static final String ERRO_VALIDACAO = "Erro De Validação";

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartErrorDTO> objectNotFound(ObjectNotFoundException objectNotFound,
			HttpServletRequest request) {

		StandartErrorDTO erroOcorrido = new StandartErrorDTO(HttpStatus.NOT_FOUND.value(), objectNotFound.getMessage(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroOcorrido);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandartErrorDTO> dataIntegrity(DataIntegrityException dataIntegrityException,
			HttpServletRequest request) {

		StandartErrorDTO erroOcorrido = new StandartErrorDTO(HttpStatus.BAD_REQUEST.value(), dataIntegrityException.getMessage(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroOcorrido);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartErrorDTO> argumentsValidation(MethodArgumentNotValidException methodArgumentNotValidException,
			HttpServletRequest request) {

		ValidationError erroOcorrido = new ValidationError(HttpStatus.BAD_REQUEST.value(), ERRO_VALIDACAO,
				System.currentTimeMillis());
		
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			erroOcorrido.addError(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroOcorrido);
	}

}
