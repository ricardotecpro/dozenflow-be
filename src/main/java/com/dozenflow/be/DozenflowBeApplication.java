package com.dozenflow.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class DozenflowBeApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DozenflowBeApplication.class);
		// Programmatically set the default profile to 'dev'.
		// This is the most robust way to ensure the dev profile is active for local development,
		// independent of IDE configurations or launch scripts. It only applies if no
		// other profile is specified via properties or command line.
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "dev"));
		app.run(args);
	}

}