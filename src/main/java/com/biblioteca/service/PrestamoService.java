package com.biblioteca.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.biblioteca.helpers.ReturnDate;
import org.springframework.beans.factory.annotation.Autowired;
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

	public String crearPrestamo(@RequestBody Prestamo prestamo) {
		usuario = usuarioDao.findByCedula(prestamo.getUsuario().getCedula());
		prestamo.setFechaRetorno((ReturnDate.returnDate())); //Se agrega la fecha de retorno en 8 días

		if (usuario.getEstadoUsario() == true) {
			if (usuario.getTipoUsario().equals("E") & prestamo.getEjemplares().size() < 6) {
				prestamoDao.save(prestamo);
				return "Se registró el prestamo para el usuario " + usuario.getNombres();
			} else if (usuario.getTipoUsario().equals("P")) {
				prestamoDao.save(prestamo);
				return "Se registró el prestamo para el usuario " + usuario.getNombres();
			} else {
				return "Excede la cantidad de libros posibles para el tipo de usuario";
			}

		} else {
			return "El usuario no está habilitado para realizar prestamo";
		}

	}

	public List < Prestamo > consultarTodos() {
		return prestamoDao.findAll();
	}

	public List < Prestamo > consultarPrestamoUsuarioFecha(@RequestParam Integer month, @RequestParam Integer year, @RequestParam String cedula) {
		List < String > fechas = ReturnDate.returnDates(month, year);
		return prestamoDao.findByUserAndDate(fechas.get(0), fechas.get(1), cedula);
	}

	public String devolverLibros(@RequestParam Integer id) {
		Prestamo prestamo = prestamoDao.getById(id);
		Usuario usuario = usuarioDao.findByCedula(prestamo.getUsuario().getCedula());
		prestamo.setEstado(true); //devueltos
		prestamoDao.save(prestamo);
		usuario.setEstadoUsario(true); //habilitado para nuevos prestamos
		usuarioDao.save(usuario);
		return "Se registró la devolución de los libros";
	}

	//	public Autor consultarAutor(@RequestParam int cedula) {
	//		return (Autor) prestamoDao.findByCedula(cedula);
	//	}

	//	public List<Autor> consultarTodos(){
	//		return prestamoDao.findAll();
	//	}

	//	public String eliminarAutor(@RequestParam int cedula) {
	//		Autor autor = (Autor) prestamoDao.findByCedula(cedula);
	//		prestamoDao.delete(autor);
	//		return "El autor con cédula " + autor.getCedula_autor() + " ha sido eliminado";
	//	}

	//	public String modificarAutor(@RequestBody int cedula) {
	//		Autor autorModif = (Autor) prestamoDaoo.findByCedula(cedula);
	//		prestamoDao.save(autorModif);
	//		return "El usuario " + autorModif.getNombres() + " ha sido modificado con éxito";
	//	}
}