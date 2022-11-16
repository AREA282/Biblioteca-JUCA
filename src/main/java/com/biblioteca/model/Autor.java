package com.biblioteca.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@Column(name = "cedula_autor")
	private int cedula;
	@Column(name = "nombres")
	private String nombres;
	@Column(name = "apellidos")
	private String apellidos;
	//    @ManyToMany(mappedBy = "autores")
	//    private List<Libro> libros;

	public int getCedula_autor() {
		return cedula;
	}
	public void setCedula_autor(int cedula_autor) {
		this.cedula = cedula_autor;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/*
	 * public List<Libro> getLibros() { return libros; } public void
	 * setLibros(List<Libro> libros) { this.libros = libros; }
	 */

}