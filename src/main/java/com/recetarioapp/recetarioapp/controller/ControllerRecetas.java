package com.recetarioapp.recetarioapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.recetarioapp.recetarioapp.entities.Ingrediente;
import com.recetarioapp.recetarioapp.entities.Paso;
import com.recetarioapp.recetarioapp.entities.Receta;
import com.recetarioapp.recetarioapp.services.ServiceIngredientesImpl;
import com.recetarioapp.recetarioapp.services.ServicePasoImpl;
import com.recetarioapp.recetarioapp.services.ServiceRecetasImpl;

@RestController
public class ControllerRecetas {
	
	@Autowired
	private ServiceRecetasImpl serviceRecetas;
	
	@Autowired
	private ServicePasoImpl servicePasos;
	
	@Autowired
	private ServiceIngredientesImpl serviceIngredientes;
	
	@RequestMapping(value="/listarecetas", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Receta>> getAllRecetas() {
		
		return new ResponseEntity<Iterable<Receta>>(serviceRecetas.getAllRecetas(), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/agregarreceta", method = RequestMethod.POST)
	public ResponseEntity<Void> addReceta(@RequestBody Receta receta) {
		
		serviceRecetas.addReceta(receta);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/maxid", method = RequestMethod.GET)
	public ResponseEntity<Integer> getmaxid() {
		
		return new ResponseEntity<Integer>(serviceRecetas.maxIdReceta(), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/agregarpasos", method = RequestMethod.POST)
	public ResponseEntity<Void> addPasos(@RequestBody Iterable<Paso> listaPasos) {
		
		servicePasos.addPaso(listaPasos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/agregaringredientes", method = RequestMethod.POST)
	public ResponseEntity<Void> addIngrediente(@RequestBody Iterable<Ingrediente> listaIngredientes) {
		
		serviceIngredientes.addIngrediente(listaIngredientes);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/eliminarreceta", method = RequestMethod.POST)
	public ResponseEntity<Void> deleteReceta(@RequestBody Receta receta) {
		
		serviceRecetas.deleteReceta(receta);
		servicePasos.deletePasosFromReceta(receta);
		serviceIngredientes.deleteIngredientesFromReceta(receta);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/bloquereceta/{id_r}", method = RequestMethod.GET)
	public ResponseEntity<Receta> getRecetaById(@PathVariable("id_r") int id_r) {
		
		return new ResponseEntity<Receta>(serviceRecetas.getReceta(id_r), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/pasosreceta/{id_r}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Paso>> getPasosById(@PathVariable("id_r") int id_r) {
		
		return new ResponseEntity<Iterable<Paso>>(servicePasos.getPasosFromReceta(id_r), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/ingredientesreceta/{id_r}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Ingrediente>> getIngredientesById(@PathVariable("id_r") int id_r) {
		
		return new ResponseEntity<Iterable<Ingrediente>>(serviceIngredientes.getIngredientesFromReceta(id_r), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/modificarreceta", method = RequestMethod.POST)
	public ResponseEntity<Void> updateReceta(@RequestBody Receta receta) {
		
		servicePasos.deletePasosFromReceta(receta);
		serviceIngredientes.deleteIngredientesFromReceta(receta);
		serviceRecetas.updateReceta(receta);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
