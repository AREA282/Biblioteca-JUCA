package com.biblioteca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prestamo")
public class Prestamo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="nota")
    private String nota;
    @Column(name="fecha_prestamo")
    private Date fechaPrestamo = new Date();
    @Column(name="fecha_retorno")
    private Date fechaRetorno;

    @ManyToMany()
    private List<Ejemplar> ejemplares;

    @ManyToOne(optional = false)
    private Usuario Usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Date getFecha_prestamo() {
		return fechaPrestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fechaPrestamo = fecha_prestamo;
	}

	public Date getFecha_retorno() {
		return fechaRetorno;
	}

	public void setFecha_retorno(Date fecha_retorno) {
		this.fechaRetorno = fecha_retorno;
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}