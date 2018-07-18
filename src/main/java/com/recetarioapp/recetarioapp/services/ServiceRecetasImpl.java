package com.recetarioapp.recetarioapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recetarioapp.recetarioapp.entities.Receta;
import com.recetarioapp.recetarioapp.repository.IRepositoryReceta;

@Service
public class ServiceRecetasImpl implements IServiceReceta {
	
	@Autowired
	private IRepositoryReceta repositoryRecetas;
	
	
	public Iterable<Receta> getAllRecetas() {
		return repositoryRecetas.findAll();
	}


	public void addReceta(Receta receta) {
		repositoryRecetas.save(receta);
	}


	public int maxIdReceta() {
		return repositoryRecetas.maxIdReceta();
	}


	public void deleteReceta(Receta receta) {
		repositoryRecetas.delete(receta.getId_r());
	}


	public Receta getReceta(Integer id_Receta) {
		return repositoryRecetas.findOne(id_Receta);
	}


	public void updateReceta(Receta receta) {
		repositoryRecetas.save(receta);	
	}
}
