package com.pokemachine.api.poke_machine_api;

import com.pokemachine.api.routers.RClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = RClient.class)
public class PokeMachineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeMachineApiApplication.class, args);
	}

}
