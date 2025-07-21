package com.educational.alura.OraculoDoSaber;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OraculoDoSaberApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OraculoDoSaberApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.mainMenu();
	}
}
