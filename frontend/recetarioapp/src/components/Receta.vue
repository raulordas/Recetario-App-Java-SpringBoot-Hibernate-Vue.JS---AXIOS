<template>
<div class="contenedoragregarreceta">
<img v-bind:src="receta.imagen"></img>
<h3>{{receta.nombre}}</h3>
<h3>{{receta.descripcion}}</h3>
<h3>{{receta.categoria}}</h3>
<br><br>
<h2>INGREDIENTES</h2>
<div v-for="item in ingredientes">
<h4>{{item.nombre}}</h4>
</div>
<br><br>
<h2>PASOS DE LA RECETA</h2>
<div v-for="item in pasos">
<h4>{{item.descripcion}}</h4>
</div>

</div>
</template>

<script>
export default {
		props: ['itemid_r'],
		data() {
			return {
				id_r: this.itemid_r,
				receta: {},
				ingredientes: [],
				pasos: []
			}
		},
		mounted() {
			axios.get('http://localhost:8083/bloquereceta/' + this.id_r)
				
			.then(response=> {
				this.receta = response.data
				
				axios.get('http://localhost:8083/ingredientesreceta/' + this.id_r)
				
				.then(response=> {
				
					this.ingredientes = response.data
					
					axios('http://localhost:8083/pasosreceta/' + this.id_r)
					
					.then(response=> {
						this.pasos = response.data
					})
					
					.catch(error=> {
						alert("No se han podido cargar los pasos de la receta");
					
					})
					
				})
				
				.catch(error=> {
					alert("No se han podido obtener los ingredientes de la receta")
				})
			})
				
			.catch(error=> {
				alert("No se ha podido cargar la receta");
			})
		}
	
}
</script>