package com.biblioteca.service;

import java.util.List;

import com.biblioteca.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroDao;

@Service
public class LibroService {

	@Autowired
	private LibroDao libroDao;

	public String crearLibro(@RequestBody Libro libro) {
		libroDao.save(libro);
		return "El libro fue creado con éxito";
	}

	public Libro consultarLibro(@RequestParam int codigo) {
		return (Libro) libroDao.findByCodigo(codigo);
	}

	public List < Libro > consultarCategoria(@RequestParam String categoria) {
		return libroDao.findByCategoria(categoria);
	}

	public List < Libro > consultarFormato(@RequestParam String formato) {
		return libroDao.findByFormato(formato);
	}

	public List < Libro > consultarEditorial(@RequestParam String editorial) {
		return libroDao.findByEditorial(editorial);
	}

	public List < Libro > consultarTodosLibros() {
		return libroDao.findAll();
	}

	public String eliminarLibro(@RequestParam int codigo) {
		Libro libro = (Libro) libroDao.findByCodigo(codigo);
		libroDao.delete(libro);
		return "El libro ha sido eliminado";
	}

	public String modificarLibro(@RequestBody int codigo) {
		Libro libroModif = (Libro) libroDao.findByCodigo(codigo);
		libroDao.save(libroModif);
		return "El usuario " + libroModif.getTitulo() + " ha sido modificado con éxito";
	}

	public List < Libro > consultarPorAutor(@RequestParam Integer autor_id) {
		return libroDao.findByAutores(autor_id);
	}

}