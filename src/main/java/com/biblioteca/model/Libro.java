package com.biblioteca.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="libro")
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="codigo_isbn")
    private int codigo;
    @Column(name="titulo")
    private int titulo;
    @Column(name="paginas")
    private int paginas;
    @Column(name="editorial")
    private int editorial;
    @Column(name="formato")
    private int formato;
    @OneToMany(mappedBy = "codigo_ejemplar")
    private Set<Ejemplar> ejemplares;


    @JoinTable(name = "libro_autor",
            joinColumns = @JoinColumn(name = "codigo_isbn"),
            inverseJoinColumns = @JoinColumn(name = "cedula_autor"))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Autor> autores;


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getTitulo() {
		return titulo;
	}


	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}


	public int getPaginas() {
		return paginas;
	}


	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}


	public int getEditorial() {
		return editorial;
	}


	public void setEditorial(int editorial) {
		this.editorial = editorial;
	}


	public int getFormato() {
		return formato;
	}


	public void setFormato(int formato) {
		this.formato = formato;
	}


	public Set<Ejemplar> getEjemplares() {
		return ejemplares;
	}


	public void setEjemplares(Set<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}


	public List<Autor> getAutores() {
		return autores;
	}


	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    



}