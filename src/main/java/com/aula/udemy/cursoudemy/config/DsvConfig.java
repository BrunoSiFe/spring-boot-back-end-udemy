package com.aula.udemy.cursoudemy.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aula.udemy.cursoudemy.services.DBService;

@Configuration
@Profile("dsv")
public class DsvConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	private static final String CREATE = "create";
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		if(CREATE.equals(strategy)) {
			dbService.intanciarBanco();
			return true;
		}
		
		return false;
	}
}
