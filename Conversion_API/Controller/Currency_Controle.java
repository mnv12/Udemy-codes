package com.example.Currency_Conversion.Conversion_API.Controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Currency_Conversion.Conversion_API.Entity.Currency_Conversion_Entity;

@RestController
public class Currency_Controle {

	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public Currency_Conversion_Entity  Currencyconversion(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		
		// invoking a restServices to other Service
		
		HashMap<String, String> uriVariable=new HashMap<>();
		
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		ResponseEntity<Currency_Conversion_Entity> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				Currency_Conversion_Entity.class,uriVariable);
		Currency_Conversion_Entity conversion_Entity = responseEntity.getBody();
		
		
		
		return new Currency_Conversion_Entity(conversion_Entity.getId(),from,to,conversion_Entity.getConversionMultiple(),
				quantity,quantity.multiply(conversion_Entity.getConversionMultiple()),conversion_Entity.getEnviroment());
	
		
	}
	
	
	
}
