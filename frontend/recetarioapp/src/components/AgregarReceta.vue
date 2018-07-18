<template>
<div class="contenedoragregarreceta">
<h3>Rellena el formulario para agregar una receta</h3>


<h4>Introduce el nombre de la receta</h4>
<input type="text" v-model="receta.nombre" class="inputbuscar" required><br><br><br><br>


<h4>Introduce la descripción de la receta</h4>
<textarea v-model="receta.descripcion" class="textbuscar" required></textarea><br><br><br><br>


<h4>Introduce una categoria</h4>
<input type="text" v-model="receta.categoria" class="inputbuscar" required><br><br><br><br><br><br>
<div class="separator">
<img src="../assets/ingredientes.svg"></img><h2>INGREDIENTES</h2>
</div>

<h4>Introduce un ingrediente</h4>
<input type="text" v-model="ingredienteAux.nombre" class="inputbuscar" required>
<br><input type="submit" class="btnform2" v-on:click="agregarIngrediente" value="Agregar Ingrediente">
<div v-for="(item, index) in ingredientes" v-on:click="eliminarIngrediente(index)">
<div class="borraringrediente">
<h3 class="textoborraringrediente">{{item.nombre}}</h3><img src="../assets/delete-icon.svg" class="botonborrar"></img>
</div>
</div>
<br><br><br><br><br><br>
<div class="separator">
<img src="../assets/map.svg"></img><h2>PASOS DE LA RECETA</h2>
</div>
<h4>Introduzca los pasos de la receta</h4>
<textarea v-model="pasoAux.descripcion" class="textbuscar" required></textarea><br><br>
<br><input type="submit" class="btnform2" v-on:click="agregarPaso" value="Agregar Paso"><br><br>
<div v-for="(item, index) in paso" v-on:click="eliminarPaso(index)">
<div class="borraringrediente">
<h3 class="textoborraringrediente">{{item.descripcion}}</h3><img src="../assets/delete-icon.svg" class="botonborrar"></img>
</div>
</div>
<br><br><br><br><br><br>
<div class="separator">

</div>
<h4>Introduzca una imagen para ilustrar la receta</h4>
<input type="file" id="valor" value="Agregar Imagen"/><br>
<h3>{{receta.imagen}}</h3>
<input type="submit" v-on:click="agregarReceta" value="Agregar Receta" class="btnform"/>


</div>
</template>
<script>
export default {
	data() {
		return {
			maxid: '',
			
			pasoAux: {
				id_r: '',
				descripcion: ''
			},
			
			ingredienteAux: {
				id_re: '',
				nombre: ''
			},
			receta: {
				nombre: '',
				descripcion: '',
				categoria: '',
				imagen: ''
			},
			paso: [{
					id_r: '',
					descripcion: 'NO HAY PASOS EN LA RECETA'
			}],
				
			ingredientes: [{
					id_re: '',
					nombre: 'SIN INGREDIENTES'
			}]
		}
	},
	
	methods: {
	
		agregarIngrediente() {
			if (this.ingredienteAux.nombre == '') {
				alert("Debe Introducir un Ingrediente"); 
			
			} else {
				this.ingredienteAux.nombre = this.ingredienteAux.nombre.toUpperCase();
		
				if (this.ingredientes[0].nombre == 'SIN INGREDIENTES') {
					this.ingredientes[0].nombre = this.ingredienteAux.nombre;
		
				} else {
					this.ingredientes.push(Object.assign({},this.ingredienteAux));
				}
			}
		},
		
		eliminarIngrediente(index){

			if (index == 0) {
				this.ingredientes[0].nombre = "SIN INGREDIENTES";
			} else {
				this.ingredientes.splice(index,1);
			}
		},
		
		agregarPaso() {
			if (this.pasoAux.descripcion == '') {
				alert("Debe Introducir un Paso"); 
			
			} else {
				this.pasoAux.descripcion = this.pasoAux.descripcion.toUpperCase();
		
				if (this.paso[0].descripcion == 'NO HAY PASOS EN LA RECETA') {
					this.paso[0].descripcion = this.pasoAux.descripcion;
		
				} else {
					this.paso.push(Object.assign({},this.pasoAux));
				}
			}
		},
		
		eliminarPaso(index){

			if (index == 0) {
				this.paso[0].descripcion = "NO HAY PASOS EN LA RECETA";
			} else {
				this.paso.splice(index,1);
			}
		},
		
		
		agregarReceta() {
			
			this.receta.imagen = 'static/' + document.getElementById("valor").files[0].name
			
			
			axios.post('http://localhost:8083/agregarreceta', this.receta)
			
			.then(response=> {
				
				response.data = this.receta
				alert("Su receta ha sido almacenada");
					
					axios.get('http://localhost:8083/maxid').then(response => {
					this.maxid = parseInt(response.data);
					
						for(var i=0; i < this.paso.length; i++) {
							this.paso[i].id_r = this.maxid;
						}
						
						for(var j=0; j < this.ingredientes.length; j++) {
							this.ingredientes[j].id_re = this.maxid;
						}
					
						axios.post('http://localhost:8083/agregarpasos', this.paso).then(response=> {
						response.data = this.paso
							
							
							axios.post('http://localhost:8083/agregaringredientes', this.ingredientes).then(response=> {
							response.data = this.ingredientes
							})
	
								.catch(e=>{
								console.log(e);
								alert("No se han podido almacenar los ingredientes");
								})
						
						
						})
	
							.catch(e=>{
							console.log(e);
							alert("No se han podido guardar los pasos de la receta");
							})
							
						.catch(function (error) {
						console.log('Error: ' + error);
						
						});
					})
			})
		
			.catch(e=>{
			console.log(e);
			alert("No se ha podido almacenar la receta");
			});
		}
	}	
}	
</script>