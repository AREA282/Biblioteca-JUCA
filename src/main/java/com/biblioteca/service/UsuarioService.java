package com.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.model.Usuario;
import com.biblioteca.repository.UsuarioDao;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	public String crearUsuario(@RequestBody Usuario usuario) {
		if (usuarioDao.findByCedula(usuario.getCedula()) != null) {
			return "El usuario que intentas ingresar ya está registrado";
		}
		usuarioDao.save(usuario);
		return "Se guardó el usuario con cédula " + usuario.getCedula();
	}

	public Usuario consultarUsuario(@RequestParam String cedula) {
		return (Usuario) usuarioDao.findByCedula(cedula);
	}

	public List < Usuario > consultarTodos() {
		return usuarioDao.findAll();
	}

	public String eliminarUsuario(@RequestParam String cedula) {
		Usuario usuario = (Usuario) usuarioDao.findByCedula(cedula);
		usuarioDao.delete(usuario);
		return "El usuario con cédula " + usuario.getCedula() + " ha sido eliminado";
	}

	public String modificarUsuario(@RequestBody String cedula) {
		Usuario usuarioModif = (Usuario) usuarioDao.findByCedula(cedula);
		usuarioDao.save(usuarioModif);
		return "El usuario " + usuarioModif.getNombres() + " ha sido modificado con éxito";
	}

}