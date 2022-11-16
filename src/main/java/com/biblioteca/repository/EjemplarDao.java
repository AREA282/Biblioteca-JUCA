package com.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Ejemplar;

@Repository
public interface EjemplarDao extends JpaRepository < Ejemplar, Integer > {

	Ejemplar findByCodigo(int codigo);

	@Query(value = "select * from ejemplar where codigo_isbn = ?", nativeQuery = true)
	List < Ejemplar > fidnByCodigo_isbn(int codigo_isbn);

}