<!-- Las direccion principal es http://localhost:port/#/rutas -->
<!-- https://www.youtube.com/watch?v=YY219kmA54A rutas dinamicas con parametros en vuerouter -->

<template>
   <!-- todo lo que este dentro de este template, se va a mostrar independiente de la ruta -->
  <!-- <nav>
    <router-link to="/perfil"><Button label="perfil" class="p-button-outlined"></Button></router-link>
    <router-link to="/">Home</router-link>  -->
    <!--cuando se usa el router link, este toma la ruta donde esta alojado-->
    
  <!-- </nav> -->
  
    <TabMenu class="tabMenu" :model="items" />
  



  <router-view/> <!--esta etiqueta hace dinamica la pagina web (que este en rojo la etiqueta no pasa nada, es un problema de vscode por tener una version vieja typescript)-->

 <!-- todo hacer un boton para que nos lleve al departamento -->
</template>

<script>
export default {
	data() {
		return {
			items: [
                {label: 'Perfil', icon: 'pi pi-user', to: '/perfil'},
                {label: 'Asistencia', icon: 'pi pi-fw pi-calendar', to: '/asistencia/2'}, //todo cambiarle el id
                {label: 'Departamento', icon: 'pi pi-building', to: '/departamento/2'}, //todo cambiarle el id
                {label: 'Busqueda', icon: 'pi pi-search', to: '/busqueda'}, 

            ]
		}
	}
}
</script>


<style>
#app {
  /* font-family: Avenir, Helvetica, Arial, sans-serif; */
  font-family: Roboto, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  /* padding: 30px; */
  padding: 10px;
  
}

.tabMenu{
  margin-bottom: 50px;
  background-color: red;
}
.p-tabmenu{
  background-color: blue;
}

.p-tabmenu-nav{
  background-color: blue;
  
  color: blue;
}

.p-tabmenuitem{
  background-color: red;
  color: red;

}

.p-highlight{
  background-color: red;
  color: red;

}

nav a {
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
}

nav a.router-link-exact-active {
  color: #42b983;
  /* text-decoration: none; */
}

a {
    text-decoration: none;
}
</style>
