package com.aula.udemy.cursoudemy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.aula.udemy.cursoudemy.entities.PagamentoComBoletoEntity;
import com.aula.udemy.cursoudemy.entities.PagamentoComCartaoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {
	
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder(){
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PagamentoComBoletoEntity.class);
				objectMapper.registerSubtypes(PagamentoComCartaoEntity.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}
