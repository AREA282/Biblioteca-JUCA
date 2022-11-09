package com.biblioteca.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ejemplar")
public class Ejemplar implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="codigo_ejemplar")
    private int codigo;
    @Column(name="edicion")
    private String edicion;
    @ManyToOne
    @JoinColumn(name="codigo_isbn", nullable=false)
    private Libro libro;

    @ManyToMany(mappedBy = "ejemplares")
    private List<Prestamo> prestamos;

	public int getCodigo_ejemplar() {
		return codigo;
	}

	public void setCodigo_ejemplar(int codigo_ejemplar) {
		this.codigo = codigo_ejemplar;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}