package com.evedev.identityprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class IdentityProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityProviderApplication.class, args);
	}
}
