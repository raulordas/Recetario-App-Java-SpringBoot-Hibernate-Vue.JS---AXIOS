package com.recetarioapp.recetarioapp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recetas")
public class Receta implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_r")
	
	private int id_r;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="categoria")
	private String categoria;
	
	
	@Column(name="imagen")
	private String imagen;
	

	public int getId_r() {
		return id_r;
	}

	public void setId_r(int id_r) {
		this.id_r = id_r;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}	
}
