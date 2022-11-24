package com.biblioteca.service;

import java.util.List;

import com.biblioteca.model.Autor;
import com.biblioteca.response.RespuestaPersonalizada;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.model.Usuario;
import com.biblioteca.repository.UsuarioDao;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	private static final Logger logger = Logger.getLogger(AutorService.class);
	public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario) {

		ResponseEntity<Object> respuesta;
		try {
			if (usuarioDao.findByCedula(usuario.getCedula()) != null) {
				RespuestaPersonalizada res= new RespuestaPersonalizada("El usuario ya existe", HttpStatus.BAD_REQUEST);
				res.setObjetoRespuesta(null);
				respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

			}else {
				RespuestaPersonalizada res = new RespuestaPersonalizada("Se registró el usuario", HttpStatus.OK);
				res.setObjetoRespuesta(usuarioDao.save(usuario));
				respuesta = new ResponseEntity<>(res, HttpStatus.OK);
			}

		}catch (Exception e){
			logger.error(e);
			RespuestaPersonalizada res= new RespuestaPersonalizada("Lo sentimos, tuvimos problemas al crear el usuario", HttpStatus.BAD_REQUEST);
			res.setObjetoRespuesta(null);
			respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}
		return respuesta;

	}

	public ResponseEntity<Object> consultarUsuario(@RequestParam String cedula) {

		ResponseEntity<Object> respuesta;
		try {
			Usuario usuario = usuarioDao.findByCedula(cedula);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta del usuario con éxito",
					HttpStatus.OK);
			res.setObjetoRespuesta(usuario);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el usuario",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> consultarTodos() {

		ResponseEntity<Object> respuesta;
		try {
			List<Usuario> usuarios =(List) usuarioDao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los usuarios con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(usuarios);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los usuarios",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> eliminarUsuario(@RequestParam String cedula) {


		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("El usuario fue eliminado correctamente", HttpStatus.OK);
			Usuario ausuarioEliminado = usuarioDao.findByCedula(cedula);
			usuarioDao.delete(ausuarioEliminado);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el autor ", HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}

		return respuesta;
	}


}