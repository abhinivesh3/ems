package com.project.emsbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmsBackendApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}


	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(EmsBackendApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
