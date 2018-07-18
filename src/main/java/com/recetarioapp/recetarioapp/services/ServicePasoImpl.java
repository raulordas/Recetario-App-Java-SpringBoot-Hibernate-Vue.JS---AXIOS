package com.recetarioapp.recetarioapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recetarioapp.recetarioapp.entities.Paso;
import com.recetarioapp.recetarioapp.entities.Receta;
import com.recetarioapp.recetarioapp.repository.IRepositoryPaso;

@Service
public class ServicePasoImpl implements IServicePaso {
	
	@Autowired
	private IRepositoryPaso repositoryPaso;
	
	public Iterable<Paso> getAllPasos() {
		return repositoryPaso.findAll();
	}

	public void addPaso(Iterable<Paso> pasos) {
		repositoryPaso.save(pasos);

	}

	public void deletePasosFromReceta(Receta receta) {
		repositoryPaso.deletePasosfromReceta(receta.getId_r());
		
	}

	public Iterable<Paso> getPasosFromReceta(Integer id_r) {
		return repositoryPaso.getPasosfromReceta(id_r);
	}

}
