package com.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biblioteca.model.Usuario;
import com.biblioteca.repository.UsuarioDao;

@SpringBootApplication
public class BibliotecaApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
