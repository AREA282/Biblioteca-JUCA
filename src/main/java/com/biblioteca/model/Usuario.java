package com.biblioteca.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Column (name="tipo_usuario")
    private String tipoUsario;
    @Column (name="estado_usuario")
    private boolean estado;
    
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipoUsario() {
		return tipoUsario;
	}
	public void setTipoUsario(String tipoUsario) {
		this.tipoUsario = tipoUsario;
	}
	public boolean getEstadoUsario() {
		return estado;
	}
	public void setEstadoUsario(boolean estadoUsario) {
		this.estado = estadoUsario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	

    


}