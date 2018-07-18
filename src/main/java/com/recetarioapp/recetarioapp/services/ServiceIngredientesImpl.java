package com.recetarioapp.recetarioapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recetarioapp.recetarioapp.entities.Ingrediente;
import com.recetarioapp.recetarioapp.entities.Receta;
import com.recetarioapp.recetarioapp.repository.IRepositoryIngredientes;

@Service
public class ServiceIngredientesImpl implements IServiceIngredientes {
	
	@Autowired
	private IRepositoryIngredientes repositoryIngredientes;

	public Iterable<Ingrediente> getAllIngredientes() {
		return repositoryIngredientes.findAll();
	}

	public void addIngrediente(Iterable<Ingrediente> listaIngrediente) {
		repositoryIngredientes.save(listaIngrediente);

	}

	public void deleteIngredientesFromReceta(Receta receta) {
		repositoryIngredientes.deleteIngredientesfromReceta(receta.getId_r());	
	}

	public Iterable<Ingrediente> getIngredientesFromReceta(Integer id_r) {
		return repositoryIngredientes.getIngredientesFromReceta(id_r);
	}
}
