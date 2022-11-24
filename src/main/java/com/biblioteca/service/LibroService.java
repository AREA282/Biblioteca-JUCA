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

import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroDao;

@Service
public class LibroService {

	@Autowired
	private LibroDao libroDao;

	private static final Logger logger = Logger.getLogger(AutorService.class);
	public ResponseEntity <Object> crearLibro(@RequestBody Libro libro) {

		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Se creó el libro con exito", HttpStatus.OK);
			res.setObjetoRespuesta(libroDao.save(libro));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de crear el libro",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;

	}

	public ResponseEntity <Object> consultarLibro(@RequestParam int codigo) {
		ResponseEntity<Object> respuesta;
		try {
			Libro libro = libroDao.findByCodigo(codigo);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta del libro con éxito",
					HttpStatus.OK);
			res.setObjetoRespuesta(libro);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el libro",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> consultarCategoria(@RequestParam String categoria) {


		ResponseEntity<Object> respuesta;
		try {
			List<Libro> libros =(List) libroDao.findByCategoria(categoria);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los libros con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(libros);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los libros",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> consultarFormato(@RequestParam String formato) {


		ResponseEntity<Object> respuesta;
		try {
			List<Libro> libros =(List) libroDao.findByFormato(formato);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los libros con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(libros);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los libros",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> consultarEditorial(@RequestParam String editorial) {

		ResponseEntity<Object> respuesta;
		try {
			List<Libro> libros =(List) libroDao.findByEditorial(editorial);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los libros con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(libros);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los libros",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;

	}

	public ResponseEntity<Object> consultarTodosLibros() {
			ResponseEntity<Object> respuesta;
		try {
			List<Libro> libros =(List) libroDao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los libros con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(libros);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los libros",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}


	public ResponseEntity<Object> eliminarLibro(@RequestParam int codigo) {

		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("El libro fue eliminado correctamente", HttpStatus.OK);
			Libro libroEliminado = libroDao.findByCodigo(codigo);
			libroDao.delete(libroEliminado);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el libro ", HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}

		return respuesta;


	}

	public ResponseEntity<Object> consultarPorAutor(@RequestParam Integer autor_id) {

		ResponseEntity<Object> respuesta;
		try {
			List<Libro> libros =(List) libroDao.findByAutores(autor_id);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los libros con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(libros);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los libros",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

}