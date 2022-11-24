package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.model.Autor;
import com.biblioteca.service.AutorService;

@RestController
@RequestMapping("api/biblioteca/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@GetMapping("consultar-autor")
	public ResponseEntity <Object> obtenerAutor(@RequestParam int cedula) {
		return autorService.consultarAutor(cedula);
	}

	@GetMapping("consultar-autores")
	public ResponseEntity <Object> obtenerAutores() {
		return autorService.consultarTodos();
	}

	@PostMapping("crear")
	public ResponseEntity<Object> crearAutor(@RequestBody Autor autor) {
		return autorService.crearAutor(autor);
	}

	@DeleteMapping("eliminar")
	public ResponseEntity <Object> eliminarAutor(@RequestParam int cedula) {
		return autorService.eliminarAutor(cedula);

	}


}