package com.recetarioapp.recetarioapp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pasos")
public class Paso implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_paso;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="id_r")
	private Integer id_r;
	
	public Integer getId_r() {
		return id_r;
	}

	public void setId_r(Integer id_r) {
		this.id_r = id_r;
	}

	public int getId_paso() {
		return id_paso;
	}

	public void setId_paso(int id_paso) {
		this.id_paso = id_paso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
