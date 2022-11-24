package com.biblioteca.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.biblioteca.helpers.ReturnDate;
import com.biblioteca.response.RespuestaPersonalizada;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.model.Autor;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.PrestamoDao;
import com.biblioteca.repository.UsuarioDao;

@Service
public class PrestamoService {

	@Autowired
	private PrestamoDao prestamoDao;

	@Autowired
	private UsuarioDao usuarioDao;

	private Usuario usuario;

	private static final Logger logger = Logger.getLogger(AutorService.class);
	public ResponseEntity<Object> crearPrestamo(@RequestBody Prestamo prestamo) {
		ResponseEntity<Object> respuesta;

		try {
			usuario = usuarioDao.findByCedula(prestamo.getUsuario().getCedula());
			prestamo.setFechaRetorno((ReturnDate.returnDate())); //Se agrega la fecha de retorno en 8 días

			if (usuario.getEstadoUsario() == true) {
				if (usuario.getTipoUsario().equals("E") & prestamo.getEjemplares().size() < 6) {
					RespuestaPersonalizada res = new RespuestaPersonalizada("Se creó el Prestamo con exito", HttpStatus.OK);
					res.setObjetoRespuesta(prestamoDao.save(prestamo));
					respuesta = ResponseEntity.ok(HttpStatus.OK);
					respuesta = new ResponseEntity<>(res, HttpStatus.OK);

				} else if (usuario.getTipoUsario().equals("P")) {
					RespuestaPersonalizada res = new RespuestaPersonalizada("Se creó el Prestamo con exito", HttpStatus.OK);
					res.setObjetoRespuesta(prestamoDao.save(prestamo));
					respuesta = ResponseEntity.ok(HttpStatus.OK);
					respuesta = new ResponseEntity<>(res, HttpStatus.OK);
				} else {
					RespuestaPersonalizada res= new RespuestaPersonalizada("Excede la cantidad de libros posibles para el tipo de usuario", HttpStatus.OK);
					res.setObjetoRespuesta(null);
					respuesta = new ResponseEntity<>(res, HttpStatus.OK);
				}

			} else {
				RespuestaPersonalizada res= new RespuestaPersonalizada("El usuario no está habilitado para realizar prestamo", HttpStatus.OK);
				res.setObjetoRespuesta(null);
				respuesta = new ResponseEntity<>(res, HttpStatus.OK);
			}
		}
		catch (Exception e){
			logger.error(e);
			RespuestaPersonalizada res= new RespuestaPersonalizada("Lo sentimos, tuvimos problemas al crear el prestamo", HttpStatus.BAD_REQUEST);
			res.setObjetoRespuesta(null);
			respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}

		return respuesta;
	}


	public ResponseEntity<Object> consultarTodos() {

		ResponseEntity<Object> respuesta;
		try {
			List<Prestamo> prestamos =(List) prestamoDao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los prestamos con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(prestamos);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los prestamos",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> consultarPrestamoUsuarioFecha(@RequestParam Integer month, @RequestParam Integer year, @RequestParam String cedula) {


		ResponseEntity<Object> respuesta;
		try {
			List < String > fechas = ReturnDate.returnDates(month, year);
			List<Prestamo> prestamos =(List) prestamoDao.findByUserAndDate(fechas.get(0), fechas.get(1), cedula);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los prestamos con exito",
					HttpStatus.OK);
			res.setObjetoRespuesta(prestamos);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los prestamos",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> devolverLibros(@RequestParam Integer id) {


		ResponseEntity<Object> respuesta;
		try {
			Prestamo prestamo = prestamoDao.getById(id);
			Usuario usuario = usuarioDao.findByCedula(prestamo.getUsuario().getCedula());
			prestamo.setEstado(true); //devueltos
			prestamoDao.save(prestamo);
			usuario.setEstadoUsario(true); //habilitado para nuevos prestamos
			usuarioDao.save(usuario);

			RespuestaPersonalizada res = new RespuestaPersonalizada("Se registró la devolución de los libros",
					HttpStatus.OK);
			res.setObjetoRespuesta(prestamo);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de devolver los libros",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}


}