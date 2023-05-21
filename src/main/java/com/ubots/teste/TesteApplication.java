package com.ubots.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class TesteApplication {

	@Autowired
    SolicitacaoManager solicitacaoManager;

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);

		SolicitacaoManager.carregaAplicacao();

	}

}
