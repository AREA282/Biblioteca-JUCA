package com.biblioteca.service;

import java.util.List;

import com.biblioteca.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.biblioteca.model.Autor;
import com.biblioteca.repository.AutorDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AutorService {

	@Autowired
	private AutorDao autorDao;

	private static final Logger logger = Logger.getLogger(AutorService.class);

	public ResponseEntity <Object> crearAutor(@RequestBody Autor autor) {
		ResponseEntity<Object> respuesta;
		try {
			if (autorDao.findByCedula(autor.getCedula_autor()) != null) {
				RespuestaPersonalizada res= new RespuestaPersonalizada("El autor ya existe", HttpStatus.BAD_REQUEST);
				res.setObjetoRespuesta(null);
				respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

			}else {
				RespuestaPersonalizada res = new RespuestaPersonalizada("Se registró el autor", HttpStatus.OK);
				res.setObjetoRespuesta(autorDao.save(autor));
				respuesta = new ResponseEntity<>(res, HttpStatus.OK);

			}

		}catch (Exception e){
			logger.error(e);
			RespuestaPersonalizada res= new RespuestaPersonalizada("Lo sentimos, tuvimos problemas al crear el autor", HttpStatus.BAD_REQUEST);
			res.setObjetoRespuesta(null);
			respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}
		return respuesta;

	}

	public ResponseEntity <Object> consultarAutor(@RequestParam int cedula) {
		ResponseEntity<Object> respuesta;
		try {
			Autor autor = autorDao.findByCedula(cedula);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta del autor con éxito",
					HttpStatus.OK);
			res.setObjetoRespuesta(autor);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el autor",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;

	}

	public ResponseEntity <Object> consultarTodos() {

		ResponseEntity<Object> respuesta;
		try {
			List<Autor> autores =(List) autorDao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los autores con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(autores);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los autores",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;

	}

	public ResponseEntity <Object> eliminarAutor(@RequestParam int cedula) {


		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("El autor fue eliminado correctamente", HttpStatus.OK);
			Autor autorEliminado = autorDao.findByCedula(cedula);
			autorDao.delete(autorEliminado);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el autor ", HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}

		return respuesta;
	}


}