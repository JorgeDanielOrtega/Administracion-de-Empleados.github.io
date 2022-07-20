<!-- Las direccion principal es http://localhost:port/#/rutas -->
<!-- https://www.youtube.com/watch?v=YY219kmA54A rutas dinamicas con parametros en vuerouter -->

<template>
  <nav> <!--todo lo que este dentro de este template, se va a mostrar independiente de la ruta-->
    <router-link to="/perfil"><Button label="perfil" class="p-button-outlined"></Button></router-link>
    <router-link to="/">Home</router-link> <!--cuando se usa el router link, este toma la ruta donde esta alojado-->
  </nav>
  <router-view/> <!--esta etiqueta hace dinamica la pagina web (que este en rojo la etiqueta no pasa nada, es un problema de vscode por tener una version vieja typescript)-->

 <!-- todo hacer un boton para que nos lleve al departamento -->
</template>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
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
</style>
