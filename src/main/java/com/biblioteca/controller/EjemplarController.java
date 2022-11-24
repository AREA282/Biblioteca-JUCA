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
import com.biblioteca.model.Ejemplar;
import com.biblioteca.service.EjemplarService;

@RestController
@RequestMapping("api/biblioteca/ejemplar")
public class EjemplarController {

	@Autowired
	private EjemplarService ejemplarService;

	@GetMapping("consultar-ejemplar")
	public ResponseEntity <Object> obtenerEjemplar(@RequestParam int codigo) {
		return ejemplarService.consultarEjemplar(codigo);
	}

	@GetMapping("consultar-ejemplares")
	public ResponseEntity <Object> obtenerEjemplares() {
		return ejemplarService.consultarTodos();
	}

	@PostMapping("crear")
	public ResponseEntity<Object> crearEjemplar(@RequestBody Ejemplar ejemplar) {
		return ejemplarService.crearEjemplar(ejemplar);
	}

	@DeleteMapping("eliminar")
	public ResponseEntity <Object> eliminarEjemplar(@RequestParam int codigo) {
		return ejemplarService.eliminarEjemplar(codigo);

	}


}