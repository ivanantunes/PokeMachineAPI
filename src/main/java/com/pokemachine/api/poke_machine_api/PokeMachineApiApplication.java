package com.pokemachine.api.poke_machine_api;

import com.pokemachine.api.routers.RClient;
import com.pokemachine.api.routers.RClientTelephone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = RClient.class)
@ComponentScan(basePackageClasses = RClientTelephone.class)
public class PokeMachineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeMachineApiApplication.class, args);
	}

}
