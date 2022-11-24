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
import com.biblioteca.model.Ejemplar;
import com.biblioteca.repository.EjemplarDao;

@Service
public class EjemplarService {

	@Autowired
	private EjemplarDao ejemplarDao;

	private static final Logger logger = Logger.getLogger(AutorService.class);

	public ResponseEntity <Object> crearEjemplar(@RequestBody Ejemplar ejemplar) {

		ResponseEntity<Object> respuesta;
		try {
			if (ejemplarDao.findByCodigo(ejemplar.getCodigo_ejemplar()) != null) {
				RespuestaPersonalizada res= new RespuestaPersonalizada("El ejemplar ya existe", HttpStatus.BAD_REQUEST);
				res.setObjetoRespuesta(null);
				respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

			}else {
				RespuestaPersonalizada res = new RespuestaPersonalizada("Se registró el ejemplar", HttpStatus.OK);
				res.setObjetoRespuesta(ejemplarDao.save(ejemplar));
				respuesta = new ResponseEntity<>(res, HttpStatus.OK);

			}

		}catch (Exception e){
			logger.error(e);
			RespuestaPersonalizada res= new RespuestaPersonalizada("Lo sentimos, tuvimos problemas al crear el ejemplar", HttpStatus.BAD_REQUEST);
			res.setObjetoRespuesta(null);
			respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}
		return respuesta;
	}

	public ResponseEntity <Object> consultarEjemplar(@RequestParam int codigo) {

		ResponseEntity<Object> respuesta;
		try {
			Ejemplar ejemplar = ejemplarDao.findByCodigo(codigo);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta del ejemplar con éxito",
					HttpStatus.OK);
			res.setObjetoRespuesta(ejemplar);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el ejemplar",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity <Object> consultarTodos() {

		ResponseEntity<Object> respuesta;
		try {
			List<Ejemplar> ejemplares =(List) ejemplarDao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los ejemplares con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(ejemplares);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los ejemplares",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity <Object> eliminarEjemplar(@RequestParam int codigo) {


		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("El ejemplar fue eliminado correctamente", HttpStatus.OK);
			Ejemplar ejemplarEliminado = ejemplarDao.findByCodigo(codigo);
			ejemplarDao.delete(ejemplarEliminado);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el ejemplar ", HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}

		return respuesta;
	}


}