<template>
<div class="contenedorrecetas">
<h3>Introduce términos para buscar tu receta</h3>
<input type="text" v-model="filtro" class="inputbuscar"><br><br><br><br>
<div class="bloquereceta" v-for="item in filtrarPorNombre">
<h5>{{item.nombre}}</h5>
<img v-bind:src="item.imagen"></img>


</div>
</div>
</body>
</template>

<script>
export default {

	data() {
		return {
		receta: [{
		nombre: 'NIGIRI PEZ MANTEQUILLA CON TRUFA',
		imagen: 'static/7.jpg'}, {
		nombre: 'LUBINA A LA ESPALDA',
		imagen: 'static/7.jpg'},{
		nombre: 'TATAKI DE BONITO DEL NORTE CON SOJA CÍTRICA',
		imagen: 'static/7.jpg'},{
		nombre: 'receton',
		imagen: 'static/7.jpg'},{
		nombre: 'receton',
		imagen: 'static/7.jpg'},
		],
		
		filtro: ''
		
		}
	},
	
	mounted() {
		this.imagen = 'static/7.jpg'
	},
	
	computed: {
		filtrarPorNombre: function() {
			return this.encontrar(this.receta, this.filtro.toUpperCase())
		}
	},
	
	methods: {
		encontrar: function(receta, filtro) {
			return receta.filter(function(item){
			return item.nombre.includes(filtro)
			
			})
		}
	}
}
</script>