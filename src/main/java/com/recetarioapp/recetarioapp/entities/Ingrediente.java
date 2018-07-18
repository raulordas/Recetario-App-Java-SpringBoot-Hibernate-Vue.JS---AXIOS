package com.recetarioapp.recetarioapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ingredientes")
public class Ingrediente implements Serializable {
	
	@Id
	@Column(name="id_ingrediente")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_ingrediente;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="id_re")
	private int id_re;

	public int getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(int id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_re() {
		return id_re;
	}

	public void setId_re(int id_re) {
		this.id_re = id_re;
	}
}
