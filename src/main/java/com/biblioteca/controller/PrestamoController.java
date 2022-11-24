package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.model.Prestamo;
import com.biblioteca.service.PrestamoService;

@RestController
@RequestMapping("api/biblioteca/prestamo")
public class PrestamoController {

	@Autowired
	private PrestamoService prestamoService;

	@PostMapping("crear")
	public ResponseEntity<Object> crearPrestamo(@RequestBody Prestamo prestamo) {
		return prestamoService.crearPrestamo(prestamo);

	}

	@GetMapping("consultar-prestamos")
	public ResponseEntity <Object> consultarPrestamos() {
		return prestamoService.consultarTodos();

	}

	@GetMapping("devolver")
	public ResponseEntity <Object> devolverPrestamo(@RequestParam Integer id) {
		return prestamoService.devolverLibros(id);

	}

	@GetMapping("usuario-fecha")
	public ResponseEntity <Object> devolverPrestamo(@RequestParam Integer month, @RequestParam Integer year, @RequestParam String cedula) {

		return prestamoService.consultarPrestamoUsuarioFecha(month, year, cedula);
	}

}