package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Autor;

@Repository
public interface AutorDao extends JpaRepository<Autor, Integer>{
	
	Autor findByNombres(String nombres);
	
	Autor findByCedula(int cedula);

}
