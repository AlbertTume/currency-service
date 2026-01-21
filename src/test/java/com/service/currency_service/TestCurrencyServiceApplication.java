package com.service.currency_service;

import org.springframework.boot.SpringApplication;

public class TestCurrencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(CurrencyServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
