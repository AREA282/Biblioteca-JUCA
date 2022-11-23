package com.biblioteca.repository;

import java.util.Date;
import java.util.List;

import com.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Prestamo;

@Repository
public interface PrestamoDao extends JpaRepository < Prestamo, Integer > {

	Prestamo findByFechaPrestamo(Date fechaPrestamo);

	@Query(nativeQuery = true, value = "select * from prestamo where fecha_prestamo BETWEEN :first AND :second and usuario_cedula = :cedula")
	List < Prestamo > findByUserAndDate(String first, String second, String cedula);

	@Query(nativeQuery = true, value = "select * from prestamo where fecha_retorno < curdate() and estado = 0 and penalizado =0")
	List < Prestamo > findByVencidos();

}