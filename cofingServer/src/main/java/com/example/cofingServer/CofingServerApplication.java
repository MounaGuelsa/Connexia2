package com.example.cofingServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CofingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CofingServerApplication.class, args);
	}

}
