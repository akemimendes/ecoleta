package com.akemi.ecoleta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akemi.ecoleta.service.DBService;

@Configuration
public class TestInicial {

    @Autowired
	private DBService dbService;
	
	@Bean
	public DBService instanciaDB() {
		this.dbService.inicializar();
        return dbService;
	}
}
