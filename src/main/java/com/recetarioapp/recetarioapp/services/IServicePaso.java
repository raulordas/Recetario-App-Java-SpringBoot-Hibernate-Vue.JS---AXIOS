package com.recetarioapp.recetarioapp.services;

import com.recetarioapp.recetarioapp.entities.Paso;
import com.recetarioapp.recetarioapp.entities.Receta;

public interface IServicePaso {
	public Iterable<Paso> getAllPasos();
	public void addPaso(Iterable<Paso> paso);
	public void deletePasosFromReceta(Receta receta);
	public Iterable<Paso> getPasosFromReceta(Integer id_r);
}
