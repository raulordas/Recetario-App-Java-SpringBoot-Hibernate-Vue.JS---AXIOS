package com.recetarioapp.recetarioapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.recetarioapp.recetarioapp.entities.Ingrediente;

public interface IRepositoryIngredientes extends CrudRepository<Ingrediente, Integer> {
	
	@Transactional
	@Modifying
	@Query("delete from Ingrediente i where i.id_re = ?1")
	public void deleteIngredientesfromReceta(int idReceta);
	
	@Query("select i from Ingrediente i where i.id_re = ?1")
	public Iterable<Ingrediente> getIngredientesFromReceta(Integer idReceta);
}
