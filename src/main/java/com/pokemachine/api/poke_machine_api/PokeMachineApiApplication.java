package com.pokemachine.api.poke_machine_api;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import com.pokemachine.api.routers.RClient;
import com.pokemachine.api.routers.RClientTelephone;
import com.pokemachine.api.routers.RCreateFullAccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = RClient.class)
@ComponentScan(basePackageClasses = RClientTelephone.class)
@ComponentScan(basePackageClasses = RCreateFullAccount.class)
public class PokeMachineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeMachineApiApplication.class, args);
	}

}
