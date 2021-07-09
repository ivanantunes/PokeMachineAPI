package com.pokemachine.api.poke_machine_api;

import com.pokemachine.api.routers.RCard;
import com.pokemachine.api.routers.RCashMachine;
import com.pokemachine.api.routers.RClient;
import com.pokemachine.api.routers.RClientTelephone;
import com.pokemachine.api.routers.RCreateFullAccount;
import com.pokemachine.api.routers.RLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = RClient.class)
@ComponentScan(basePackageClasses = RClientTelephone.class)
@ComponentScan(basePackageClasses = RCreateFullAccount.class)
@ComponentScan(basePackageClasses = RLogin.class)
@ComponentScan(basePackageClasses = RCard.class)
@ComponentScan(basePackageClasses = RCashMachine.class)
public class PokeMachineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeMachineApiApplication.class, args);
	}

}
