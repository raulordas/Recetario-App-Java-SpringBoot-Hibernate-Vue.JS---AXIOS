<template>
<modal >
</modal>
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