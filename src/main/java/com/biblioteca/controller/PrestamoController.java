package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("devolver")
	public String devolverPrestamo(@RequestParam Integer id) {
		return prestamoService.devolverLibros(id);

	}

	@GetMapping("usuario-fecha")
	public List<Prestamo> devolverPrestamo(@RequestParam Integer month, @RequestParam Integer year, @RequestParam String cedula) {

		return prestamoService.consultarPrestamoUsuarioFecha(month, year, cedula);
	}

}
