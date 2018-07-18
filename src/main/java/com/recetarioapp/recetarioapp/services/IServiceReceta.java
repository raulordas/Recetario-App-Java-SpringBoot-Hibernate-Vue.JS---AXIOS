package com.recetarioapp.recetarioapp.services;

import com.recetarioapp.recetarioapp.entities.Receta;

public interface IServiceReceta {
	public Iterable<Receta> getAllRecetas();
	public void addReceta(Receta receta);
	public int maxIdReceta();
	public void deleteReceta(Receta receta);
	public Receta getReceta(Integer id_Receta);
	public void updateReceta(Receta receta);
}
