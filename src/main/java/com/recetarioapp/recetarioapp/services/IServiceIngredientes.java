package com.recetarioapp.recetarioapp.services;

import com.recetarioapp.recetarioapp.entities.Ingrediente;
import com.recetarioapp.recetarioapp.entities.Receta;

public interface IServiceIngredientes {
	public Iterable<Ingrediente> getAllIngredientes();
	public void addIngrediente(Iterable<Ingrediente> ingrediente);
	public void deleteIngredientesFromReceta(Receta receta);
	public Iterable<Ingrediente> getIngredientesFromReceta(Integer id_r);
}
