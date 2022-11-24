package com.biblioteca.response;

import org.springframework.data.mapping.model.PropertyNameFieldNamingStrategy;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RespuestaPersonalizada {

    private String codigo;
    private String descripcion;
    private int estado;
    private Object objetoRespuesta;


    public RespuestaPersonalizada() {

    }

    public RespuestaPersonalizada(String descripcion, HttpStatus estado) {
        super();

        this.descripcion = descripcion;
        this.estado = estado.value();
        this.codigo = estado.name();

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Object getObjetoRespuesta() {
        return objetoRespuesta;
    }

    public void setObjetoRespuesta(Object objetoRespuesta) {
        this.objetoRespuesta = objetoRespuesta;
    }


}