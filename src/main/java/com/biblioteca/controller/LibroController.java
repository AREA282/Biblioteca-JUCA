package com.biblioteca.controller;

import java.util.List;

import com.biblioteca.model.Autor;
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

import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;

@RestController
@RequestMapping("api/biblioteca/libro")
public class LibroController {

	@Autowired
	private LibroService libroService;

	@GetMapping("consultar-libro")
	public ResponseEntity<Object> obtenerLibro(@RequestParam int codigo) {
		return libroService.consultarLibro(codigo);
	}

	@GetMapping("consultar-libros")
	public ResponseEntity <Object> obtenerLibros() {
		return libroService.consultarTodosLibros();
	}

	@GetMapping("consultar-categoria")
	public ResponseEntity <Object> obtenerCategoria(@RequestParam String categoria) {
		return libroService.consultarCategoria(categoria);
	}

	@GetMapping("consultar-autor")
	public ResponseEntity <Object> obttenerLibroPorAutores(@RequestParam Integer autor_id) {
		return libroService.consultarPorAutor(autor_id);
	}

	@GetMapping("consultar-formato")
	public ResponseEntity <Object> obtenerFormato(@RequestParam String formato) {
		return libroService.consultarFormato(formato);
	}

	@GetMapping("consultar-editorial")
	public ResponseEntity <Object> obtenerEditorial(@RequestParam String editorial) {
		return libroService.consultarEditorial(editorial);
	}

	@PostMapping("crear")
	public ResponseEntity <Object> crearLibro(@RequestBody Libro libro) {
		return libroService.crearLibro(libro);
	}

	@DeleteMapping("eliminar")
	public ResponseEntity <Object> eliminarLibro(@RequestParam int codigo) {
		return libroService.eliminarLibro(codigo);

	}


}