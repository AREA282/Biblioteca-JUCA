package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.model.Ejemplar;
import com.biblioteca.service.EjemplarService;

@RestController
@RequestMapping("api/biblioteca/ejemplar")
public class EjemplarController {
	
	@Autowired
	private EjemplarService ejemplarService;
	
	@GetMapping("consultar-ejemplar")
	public Ejemplar obtenerEjemplar(@RequestParam int codigo){
		return ejemplarService.consultarEjemplar(codigo);
	}
	
	@GetMapping("consultar-ejemplares")
	public List<Ejemplar> obtenerEjemplares(){
		return ejemplarService.consultarTodos();
	}
	
	@PostMapping("crear")
	public String crearEjemplar(@RequestBody Ejemplar ejemplar) {
		return ejemplarService.crearEjemplar(ejemplar);
	}
	
	@DeleteMapping("eliminar")
	public String eliminarEjemplar(@RequestParam int codigo) {
		return ejemplarService.eliminarEjemplar(codigo);
		
	}
	
	@PutMapping("modificar")
	public String modificarEjemplar(@RequestBody int codigo) {
		return ejemplarService.modificarEjemplar(codigo);
	}

}
