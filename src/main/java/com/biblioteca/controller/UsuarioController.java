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

import com.biblioteca.model.Usuario;
import com.biblioteca.service.UsuarioService;

@RestController
@RequestMapping("api/biblioteca/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("consultar-usuario")
	public ResponseEntity<Object> obtenerUsuario(@RequestParam String cedula) {
		return usuarioService.consultarUsuario(cedula);
	}

	@GetMapping("consultar-usuarios")
	public ResponseEntity<Object> obtenerUsuarios() {
		return usuarioService.consultarTodos();
	}

	@PostMapping("crear")
	public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.crearUsuario(usuario);
	}

	@DeleteMapping("eliminar")
	public ResponseEntity<Object> eliminarUsuario(@RequestParam String cedula) {
		return usuarioService.eliminarUsuario(cedula);

	}

}