package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Libro;

@Repository
public interface LibroDao extends JpaRepository<Libro, Integer> {
	
	Libro findByCodigo(int codigo);
	
	Libro findByCategoria(String categoria);
	
	Libro findByFormato(String formato);
	
	Libro findByAutor(String autor);
	
	Libro findByEditorial(String editorial);
}
