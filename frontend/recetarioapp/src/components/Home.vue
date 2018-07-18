<template>
<div class="contenedorrecetas">
<h4>Bienvenido a Recetario App. Esta aplicación ha sido desarrollada utilizando SpringBoot + Hibernate como Backend Java y REST Api. El frontend
ha sido desarrollado utilizando Vue.JS y AXIOS para la comunicación cliente-servidor. El objetivo era desarrollar una práctica que permitiera
realizar un CRUD como web app. Todos los datos se almacenan en una base de datos SQLite. Si bien todos sabemos que para realizar un blog es suficiente
con utilizar wordpress, siempre produce más satisfacción tener tu propio wordpress. :)</h4>

<h2>ELIGE UNA OPCIÓN DEL MENÚ</h2>
<h6>...y no me refiero en este caso a un menú de comida :)</h6><br><br>
<div>
<img src="static/food.jpg"></img>
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
		}
	}
}
</script>