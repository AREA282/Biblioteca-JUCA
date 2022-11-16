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

import com.biblioteca.model.Usuario;
import com.biblioteca.service.UsuarioService;

@RestController
@RequestMapping("api/biblioteca/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("consultar-usuario")
	public Usuario obtenerUsuario(@RequestParam String cedula) {
		return usuarioService.consultarUsuario(cedula);
	}

	@GetMapping("consultar-usuarios")
	public List < Usuario > obtenerUsuarios() {
		return usuarioService.consultarTodos();
	}

	@PostMapping("crear")
	public String crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.crearUsuario(usuario);
	}

	@DeleteMapping("eliminar")
	public String eliminarUsuario(@RequestParam String cedula) {
		return usuarioService.eliminarUsuario(cedula);

	}

	@PutMapping("modificar")
	public String modificarUsuario(@RequestBody String cedula) {
		return usuarioService.modificarUsuario(cedula);
	}

}