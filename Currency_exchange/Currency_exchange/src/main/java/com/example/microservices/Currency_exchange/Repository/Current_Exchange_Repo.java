package com.example.microservices.Currency_exchange.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.Currency_exchange.Entity.CurrencyExchange;

public interface Current_Exchange_Repo extends JpaRepository<CurrencyExchange, Long>{
	
    CurrencyExchange findByFromAndTo(String from,String to);

}
