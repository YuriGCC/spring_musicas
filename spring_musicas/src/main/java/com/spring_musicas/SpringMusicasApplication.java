package com.spring_musicas;

import com.spring_musicas.repositorio.ArtistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spring_musicas.principal.Principal;

@SpringBootApplication
public class SpringMusicasApplication implements CommandLineRunner {
	@Autowired
	private ArtistaRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(SpringMusicasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
