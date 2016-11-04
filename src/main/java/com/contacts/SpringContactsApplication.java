package com.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootApplication
public class SpringContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringContactsApplication.class, args);
	}
}
