package com.biblioteca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.biblioteca.model.Autor;
import com.biblioteca.repository.AutorDao;

@Service
public class AutorService {
	
	@Autowired
	private AutorDao autorDao;
	
	public String crearAutor(@RequestBody Autor autor) {
		if(autorDao.findByCedula(autor.getCedula_autor()) != null ) {
			return "El autor que intentas ingresar ya está registrado";
		}
		autorDao.save(autor);
		return "Se guardó el usuario con cédula " + autor.getCedula_autor();
	}
	
	public Autor consultarAutor(@RequestParam int cedula) {
		return (Autor) autorDao.findByCedula(cedula);
	}
	
	public List<Autor> consultarTodos(){
		return autorDao.findAll();
	}
	
	public String eliminarAutor(@RequestParam int cedula) {
		Autor autor = (Autor) autorDao.findByCedula(cedula);
		autorDao.delete(autor);
		return "El autor con cédula " + autor.getCedula_autor() + " ha sido eliminado";
	}
	
	public String modificarAutor(@RequestBody int cedula) {
		Autor autorModif = (Autor) autorDao.findByCedula(cedula);
		autorDao.save(autorModif);
		return "El usuario " + autorModif.getNombres() + " ha sido modificado con éxito";
	}

}
