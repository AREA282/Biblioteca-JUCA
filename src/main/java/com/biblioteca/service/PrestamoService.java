package com.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.model.Autor;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.PrestamoDao;


@Service
public class PrestamoService {
	
	@Autowired
	private PrestamoDao prestamoDao;
	
	@Autowired
	private Usuario usuarioDao;
	
	public String crearPrestamo(@RequestBody Prestamo prestamo) {
		Usuario usuario = usuarioDao.findByCedula(reserva.getSala().getId()).get(0);
		prestamoDao.save(prestamo);
		return "Se guardó el usuario con cédula " + autor.getCedula_autor();
	}
	
	public Autor consultarAutor(@RequestParam int cedula) {
		return (Autor) prestamoDao.findByCedula(cedula);
	}
	
	public List<Autor> consultarTodos(){
		return prestamoDao.findAll();
	}
	
	public String eliminarAutor(@RequestParam int cedula) {
		Autor autor = (Autor) prestamoDao.findByCedula(cedula);
		prestamoDao.delete(autor);
		return "El autor con cédula " + autor.getCedula_autor() + " ha sido eliminado";
	}
	
	public String modificarAutor(@RequestBody int cedula) {
		Autor autorModif = (Autor) prestamoDaoo.findByCedula(cedula);
		prestamoDao.save(autorModif);
		return "El usuario " + autorModif.getNombres() + " ha sido modificado con éxito";
	}
}
