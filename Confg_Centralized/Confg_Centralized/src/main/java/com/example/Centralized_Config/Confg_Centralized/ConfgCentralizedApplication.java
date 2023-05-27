package com.example.Centralized_Config.Confg_Centralized;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableConfigServer
public class ConfgCentralizedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfgCentralizedApplication.class, args);
	}

}
