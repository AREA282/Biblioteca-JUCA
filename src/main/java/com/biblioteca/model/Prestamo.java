package com.biblioteca.model;

import java.io.Serializable;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prestamo")
public class Prestamo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="id")
	private int id;
}
