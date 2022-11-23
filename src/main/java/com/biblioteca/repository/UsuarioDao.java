package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioDao extends JpaRepository < Usuario, String > {

	Usuario findByCedula(String cedula);

	List<Usuario> findByEstado(boolean estado);

}