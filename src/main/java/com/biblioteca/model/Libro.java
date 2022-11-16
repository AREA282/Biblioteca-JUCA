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
@Table(name = "libro")
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo_isbn")
	private int codigo;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "paginas")
	private int paginas;
	@Column(name = "editorial")
	private String editorial;
	@Column(name = "formato")
	private String formato;
	@Column(name = "categoria")
	private String categoria;

	/*@JoinTable(name = "libro_autor",
            joinColumns = @JoinColumn(name = "codigo_isbn"),
            inverseJoinColumns = @JoinColumn(name = "cedula_autor"))*/
	@ManyToMany(cascade = CascadeType.MERGE)
	private List < Autor > autores;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getFormato() {
		return formato;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public List < Autor > getAutores() {
		return autores;
	}

	public void setAutores(List < Autor > autores) {
		this.autores = autores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}