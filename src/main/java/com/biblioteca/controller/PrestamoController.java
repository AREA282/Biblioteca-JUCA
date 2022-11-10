package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Prestamo;
import com.biblioteca.service.PrestamoService;



@RestController
@RequestMapping("api/biblioteca/prestamo")
public class PrestamoController {

	@Autowired
	private PrestamoService prestamoService;
	
	@PostMapping("crear")
	public String crearPrestamo(@RequestBody Prestamo prestamo) {
		return prestamoService.crearPrestamo(prestamo);
		
	}
	
	@GetMapping("consultar-prestamos")
	public List<Prestamo> consultarPrestamos() {
		return prestamoService.consultarTodos();
		
	}

}
