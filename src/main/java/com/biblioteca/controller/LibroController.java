package com.biblioteca.controller;

import java.util.List;

import com.biblioteca.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Libro obtenerLibro(@RequestParam int codigo){
		return libroService.consultarLibro(codigo);
	}
	
	@GetMapping("consultar-libros")
	public List<Libro> obtenerLibros(){
		return libroService.consultarTodosLibros();
	}
	
	@GetMapping("consultar-categoria")
	public List<Libro> obtenerCategoria(@RequestParam String categoria){
		return libroService.consultarCategoria(categoria);
	}


	@GetMapping("consultar-autor")
	public List<Libro> obttenerLibroPorAutores(@RequestParam Integer autor_id){
		return libroService.consultarPorAutor(autor_id);
	}


	@GetMapping("consultar-formato")
	public List<Libro> obtenerFormato(@RequestParam String formato){
		return libroService.consultarFormato(formato);
	}
	
	@GetMapping("consultar-editorial")
	public List<Libro> obtenerEditorial(@RequestParam String editorial){
		return libroService.consultarEditorial(editorial);
	}
	
	@PostMapping("crear")
	public String crearLibro(@RequestBody Libro libro) {
		return libroService.crearLibro(libro);
	}
	
	@DeleteMapping("eliminar")
	public String eliminarLibro(@RequestParam int codigo) {
		return libroService.eliminarLibro(codigo);
		
	}
	
	@PutMapping("modificar")
	public String modificarLibro(@RequestBody int codigo) {
		return libroService.modificarLibro(codigo);
	}

}
