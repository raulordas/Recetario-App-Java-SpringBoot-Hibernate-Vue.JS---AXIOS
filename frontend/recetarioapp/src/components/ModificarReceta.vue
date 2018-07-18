<template>
<div class="contenedorrecetas">
<h3>Introduce términos para buscar la receta que desees modificar</h3>
<input type="text" v-model="filtro" class="inputbuscar"><br><br><br><br>
<div class="bloquereceta" v-for="item in filtrarPorNombre" v-on:click="seleccionar(item)">
<h5>{{item.nombre}}</h5>
<img v-bind:src="item.imagen"></img>
</div>
</div>

</template>

<script>
export default {

	data() {
		return {
		receta: [],
		filtro: ''
		
		}
	},
	
	mounted() {

	axios.get('http://localhost:8083/listarecetas').then(response => (this.receta = response.data)).catch(function (error) {
	
       console.log('Error: ' + error);
	   alert("No se han podido cargar las recetas");
	}); 
	
	},
	
	computed: {
		filtrarPorNombre: function() {
			return this.encontrar(this.receta, this.filtro.toUpperCase())
		}
	},
	
	methods: {
		encontrar: function(receta, filtro) {
			return receta.filter(function(item){
			return item.nombre.toUpperCase().includes(filtro)
			
			})
		},
		
		seleccionar: function(item) {
			this.$router.push("/modificaseleccion/" + item.id_r)
		}
	}
}
</script>