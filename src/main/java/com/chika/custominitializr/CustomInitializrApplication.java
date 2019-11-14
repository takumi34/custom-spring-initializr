package com.chika.custominitializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CustomInitializrApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomInitializrApplication.class, args);
	}

}
