package com.recetarioapp.recetarioapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.recetarioapp.recetarioapp.entities.Paso;

public interface IRepositoryPaso extends CrudRepository<Paso, Integer> {
	
	@Transactional
	@Modifying
	@Query("delete from Paso p where p.id_r = ?1")
	public void deletePasosfromReceta(int idReceta);
	
	@Query("select p from Paso p where p.id_r = ?1")
	public Iterable<Paso> getPasosfromReceta(int idReceta);
}
