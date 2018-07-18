import Vue from 'vue'
import Router from 'vue-router'
import BloqueReceta from './components/BloqueReceta.vue'
import AgregarReceta from './components/AgregarReceta.vue'
import EliminarReceta from './components/EliminarReceta.vue'
import Home from './components/Home.vue'
import ModalReceta from './components/ModalReceta.vue'
import Receta from './components/Receta.vue'
import ModificarReceta from './components/ModificarReceta.vue'
import ModificaSeleccion from './components/ModificaSeleccion.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/bloquereceta',
      name: 'bloquereceta',
      component: BloqueReceta
    },
	
	{
	  path: '/bloquereceta/:itemid_r',
	  name: 'receta',
	  component: Receta,
	  props: true
		
	},
	
	{
		path: '/agregarreceta',
		name: 'agregarreceta',
		component: AgregarReceta
	},
	
	{
		path: '/eliminarreceta',
		name: 'eliminarreceta',
		component: EliminarReceta
	},
	{
		path: '/home',
		name: 'home',
		component: Home
	},
	{
		path:'/modalReceta',
		name: 'modalreceta',
		component: ModalReceta
	},
	{
		path: '/modificareceta',
		name: 'modificareceta',
		component: ModificarReceta
	},
	{
		path: '/modificaseleccion/:itemid_r',
		name: 'modificaseleccion',
		component: ModificaSeleccion,
		props: true
	}
  ]
})
