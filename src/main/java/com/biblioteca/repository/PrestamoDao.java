package com.biblioteca.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Prestamo;

@Repository
public interface PrestamoDao extends JpaRepository<Prestamo, Integer>{
	
	Prestamo findByFechaPrestamo(Date fechaPrestamo);

}
