package com.biblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="cedula")
	private String cedula;
	@Column(name="nombres")
	private String nombres;
	@Column (name="apellidos")
	private String apellidos;
	@Column(name="direccion")
	private String direccion;
	@Column (name="telefono")
	private String telefono;
	@JoinColumn(name = "tipoUsuario")
	@OneToMany
	private TipoUsuario tipoUsuario;
	
}
