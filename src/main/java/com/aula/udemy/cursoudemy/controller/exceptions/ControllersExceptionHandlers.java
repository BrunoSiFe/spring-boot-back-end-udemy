package com.aula.udemy.cursoudemy.controller.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aula.udemy.cursoudemy.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControllersExceptionHandlers {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartErrorDTO> objectNotFound(ObjectNotFoundException objectNotFound,
			HttpServletRequest request) {

		StandartErrorDTO erroOcorrido = new StandartErrorDTO(HttpStatus.NOT_FOUND.value(), objectNotFound.getMessage(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroOcorrido);
	}
}
