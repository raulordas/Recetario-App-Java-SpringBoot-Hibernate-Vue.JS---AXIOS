<template>
  <div id="app">
   <div class="topnav" id="myTopnav">
  <router-link to="/home">Inicio</router-link>
  <router-link to="/bloquereceta">Consultar Receta</router-link>
  <router-link to="/agregarreceta">Agregar Receta</router-link>
  <router-link to="/modificareceta">Modificar Receta</router-link>
  <router-link to="/eliminarreceta">Eliminar Receta</router-link>
	
	
  
  <!--Botón Acerca De-->
  <a v-on:click="enviar">Acerca de Recetario App</a>
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>
<br><br><div id="logo"><img src="LOGOLOWR.png"></div><br><br>
<router-view></router-view>
 <!--Footer-->
<br><br><footer>
<p class = "pfooter">Receta App 1.0 - Aplicación desarrollada por Raúl Ordás Fernández<br>
<a href="https://github.com/raulordas/Recetario-App-Java-SpringBoot-Hibernate-Vue.JS---AXIOS/wiki">Wiki Github Recetario App</a></p>
</footer>
  </div>
  
</template>

<style>
  @import 'css/estilos.css';
</style>

<script>
export default {

	methods: {
	enviar() {
	alert('Recetario App 1.0 - Aplicación desarrollada por Raúl Ordás: ordasraul@gmail.com');
	}
	}
}
</script>


