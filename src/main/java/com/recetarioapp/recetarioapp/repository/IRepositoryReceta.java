package com.recetarioapp.recetarioapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.recetarioapp.recetarioapp.entities.Receta;

public interface IRepositoryReceta extends CrudRepository<Receta, Integer> {
	
	@Query("SELECT MAX(r.id_r) from Receta r")
	public int maxIdReceta();
}
