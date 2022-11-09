package com.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.biblioteca.model.Ejemplar;
import com.biblioteca.repository.EjemplarDao;

@Service
public class EjemplarService {
	
	@Autowired
	private EjemplarDao ejemplarDao;
	
	public String crearEjemplar(@RequestBody Ejemplar ejemplar) {
		if(ejemplarDao.findByCodigo(ejemplar.getCodigo_ejemplar()) != null ) {
			return "El ejemplar que intentas ingresar ya está registrado";
		}
		ejemplarDao.save(ejemplar);
		return "Se guardó el ejemplar con código " + ejemplar.getCodigo_ejemplar();
	}
	
	public Ejemplar consultarEjemplar(@RequestParam int codigo) {
		return (Ejemplar) ejemplarDao.findByCodigo(codigo);
	}
	
	public List<Ejemplar> consultarTodos(){
		return ejemplarDao.findAll();
	}
	
	public String eliminarEjemplar(@RequestParam int codigo) {
		Ejemplar ejemplar = (Ejemplar) ejemplarDao.findByCodigo(codigo);
		ejemplarDao.delete(ejemplar);
		return "El ejemplar con código " + ejemplar.getCodigo_ejemplar() + " ha sido eliminado";
	}
	
	public String modificarEjemplar(@RequestBody int codigo) {
		Ejemplar ejemplarModif = (Ejemplar) ejemplarDao.findByCodigo(codigo);
		ejemplarDao.save(ejemplarModif);
		return "El ejemplar ha sido modificado con éxito";
	}

}
