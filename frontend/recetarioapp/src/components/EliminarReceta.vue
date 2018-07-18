<template>
<div id="deletereceta" class ="contform">
<br><h3> Selecione una receta para eliminar<br>Le recordamos que una vez eliminada la receta no se puede recuperar.</h3><br>
<table>
	<tr>
	<th>IDENTIFICADOR RECETA</th>
	<th>NOMBRE</th>
	</tr>
	<tr v-for="item in receta" v-on:click="eliminar(item)">
	<td>{{item.id_r}}</td>
	<td>{{item.nombre}}</td>
	</tr>
</table>
</div>

</template>

<script>
export default {
	
	data() {
		return {
			receta:[]
		}	
	},
	
	mounted() {
		axios.get('http://localhost:8083/listarecetas')
		
		.then(response=> {
			this.receta = response.data
		})
		
		.catch(error=> {
			alert("No se han podido cargar las recetas");
		})
	},
	
	methods: {
		eliminar(item) {

			var res = confirm('¿Está seguro de que desea eliminar la receta?');
			if (res==1) {
				axios.post('http://localhost:8083/eliminarreceta', item)
				
				.then(response=> {
					response.data = item
					alert('Se ha eliminado el registro satisfactoriamente');
				})
				
				.catch(error=> {
					alert("No se ha podido eliminar la receta");
				})
			}
		}
	}
}
</script>