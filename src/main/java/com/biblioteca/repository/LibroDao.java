package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Autor;
import com.biblioteca.model.Libro;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface LibroDao extends JpaRepository < Libro, Integer > {

	Libro findByCodigo(int codigo);

	List < Libro > findByCategoria(String categoria);

	List < Libro > findByFormato(String formato);

	@Query(nativeQuery = true, value = "select * from libro inner join libro_autores la ON codigo_isbn = libro_codigo_isbn where la.autores_cedula_autor = :autor_id")
	List < Libro > findByAutores(Integer autor_id);

	List < Libro > findByEditorial(String editorial);
}