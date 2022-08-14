<!-- Las direccion principal es http://localhost:port/#/rutas -->
<!-- https://www.youtube.com/watch?v=YY219kmA54A rutas dinamicas con parametros en vuerouter -->

<template>
  <!-- todo lo que este dentro de este template, se va a mostrar independiente de la ruta -->
  <!-- <nav>
    <router-link to="/perfil"><Button label="perfil" class="p-button-outlined"></Button></router-link>
    <router-link to="/">Home</router-link>  -->
  <!--cuando se usa el router link, este toma la ruta donde esta alojado-->

  <!-- </nav> -->

  <!-- <TabMenu class="tabMenu" :model="retornarMenu()" /> -->
  <TabMenu class="tabMenu" :model="this.items" />




  <router-view />
  <!--esta etiqueta hace dinamica la pagina web (que este en rojo la etiqueta no pasa nada, es un problema de vscode por tener una version vieja typescript)-->

  <!-- todo hacer un boton para que nos lleve al departamento -->
</template>

<script>
import LoginService from "./Services/LoginService";
export default {
<<<<<<< HEAD
	data() {
		return {
			items: [

                {label: 'Perfil', icon: 'pi pi-user', to: '/perfil'},
                {label: 'Asistencia', icon: 'pi pi-fw pi-calendar', to: '/asistencia/2'}, //todo cambiarle el id
                {label: 'Departamento', icon: 'pi pi-building', to: '/departamento/2'}, //todo cambiarle el id
                {label: 'Busqueda', icon: 'pi pi-search', to: '/busqueda'}, 
                {label: 'Rol', icon:'pi pi-tablet', to: '/roles'},
                {label:"Empleados", icon: "pi pi-user", to:'/empleado'},
                {label: 'Departamentos', icon: 'pi pi-table', to: '/departamentos'}, 
=======
  data() {
    return {
      status: null,
      idLogin: null,
      items: null,
      // items: [
      //   { label: 'Login', icon: 'pi pi-user', to: '/' },
      //   { label: 'Empresa', icon: 'pi pi-building', to: '/empresa' },
      //   { label: 'Perfil', icon: 'pi pi-user-edit', to: '/perfil' },
      //   { label: 'Asistencia', icon: 'pi pi-fw pi-calendar', to: '/asistencia/2' }, //todo cambiarle el id
      //   { label: 'Departamento', icon: 'pi pi-home', to: '/departamento/2' }, //todo cambiarle el id
      //   { label: 'Busqueda', icon: 'pi pi-search', to: '/busqueda' },
      // ]
    }
  },
  loginService: null,
  created() {
    this.loginService = new LoginService();
  },
  mounted() {
    this.loginService.retornarIngreso().then(response => {
      this.login = response.data;
      this.idLogin = this.login.id;
      this.status = this.login.status;
      this.items = this.retornarMenu()
    });

  },
  methods: {
    retornarMenu() {
      console.log(this.idLogin);
      if (this.idLogin == '1') {
        this.items = [
          { label: 'Login', icon: 'pi pi-user', to: '/' },
          { label: 'Empresa', icon: 'pi pi-building', to: '/empresa' },
          { label: 'Perfil', icon: 'pi pi-user-edit', to: '/perfil/' + this.idLogin },
          { label: 'Asistencia', icon: 'pi pi-fw pi-calendar', to: '/asistencia/' + this.idLogin },
          { label: 'Busqueda', icon: 'pi pi-search', to: '/busqueda' },
          { label: 'Decimo', icon: 'pi pi-credit-card', to: '/decimo' },
        ];
        return this.items;
      } else if (this.idLogin != null) {
        this.items = [
          { label: 'Login', icon: 'pi pi-user', to: '/' },
          { label: 'Perfil', icon: 'pi pi-user-edit', to: '/perfil/' + this.idLogin },
          { label: 'Asistencia', icon: 'pi pi-fw pi-calendar', to: '/asistencia/' + this.idLogin },
          { label: 'Departamento', icon: 'pi pi-home', to: '/departamento/' + this.idLogin },
        ];
        return this.items;
      }

    }
  }

>>>>>>> ffbccdb8b09493137b92efaa9ae21f08588a8f55

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
<<<<<<< HEAD
=======

>>>>>>> ffbccdb8b09493137b92efaa9ae21f08588a8f55
}


.p-tabmenu {
  background-color: blue;
}

.p-tabmenu-nav {
  background-color: blue;

  color: blue;
}

<<<<<<< HEAD
.p-tabmenuitem{
  background-color: red;
  color: red;

}

.p-highlight{
  background-color: red;
  color: red;
}
=======
>>>>>>> ffbccdb8b09493137b92efaa9ae21f08588a8f55

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

.login {
  font-size: 35px;
}
</style>
