package com.example.microservices.Currency_exchange.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.Currency_exchange.Entity.CurrencyExchange;
import com.example.microservices.Currency_exchange.Repository.Current_Exchange_Repo;

@RestController
public class Currency_ControllerExch {

	@Autowired
	private Environment environment;
	@Autowired
	private Current_Exchange_Repo current_Exchange_Repo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieve(@PathVariable String from, @PathVariable String to) {
		// CurrencyExchange currencyExchange = new CurrencyExchange(1L, from,
		// to,BigDecimal.valueOf(1000) );
		CurrencyExchange currencyExchange = current_Exchange_Repo.findByFromAndTo(from, to);
		String port = environment.getProperty("local.server.port");

		currencyExchange.setEnviroment(port);
		return currencyExchange;

	}

}
