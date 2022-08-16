<template>
  <div v-if=status>
    <Button class="swal2-confirm swal2-styled" label="Salir" @click="salir()" />
  </div>
  <div v-else>
    <div class="titulo">
      <h1>INGRESO</h1>
    </div>

    <div class="datos">
      <label class="col" for="nombre">Usuario:</label>
      <InputText class="input" id="usuario" type="text" v-model="usuario" placeholder = "Usuario"/>
      <div class="divisor"></div>
      <label class="col" for="fundacionYear">Contraseña:</label>
      <InputText class="input" id="contrasenia" type="password" v-model="contrasenia" placeholder = "Contraseña"/>
    </div>

    <div class="buttons">
      <div class="divisor"></div>
      <Button class="swal2-confirm swal2-styled" label="Ingresar" @click="ingresar()" />
    </div>
  </div>

</template>

<script>
import LoginService from '@/Services/LoginService'

export default {
  name: 'login',
  data() {
    return {
      usuario: null,
      contrasenia: null,
      status: null,
      id: null,
    }
  },
  loginService: null,
  created() {
    this.loginService = new LoginService();
  },
  mounted() {
    this.loginService.retornarIngreso().then(response => {
      this.login = response.data;
      this.status = this.login.status;
    })
  },
  methods: {
    ingresar() {
      this.loginService.verificarIngreso(this.usuario, this.contrasenia).then(response => {
        this.login = response.data;
        this.usuario = this.login.usuario;
        this.contrasenia = this.login.contrasenia;
        this.status = this.login.status;
        this.id = this.login.id;
        if (this.status) {
          this.$router.push('/perfil/' + this.id);
        }
      });
    },
    salir() {
      this.loginService.retornarIngreso().then(response => {
        this.login = response.data;
        this.usuario = this.login.usuario;
        this.contrasenia = this.login.contrasenia;
        this.status = this.login.status;
        this.id = this.login.id;
      });

      this.loginService.salir(this.login).then(response => {
        this.login = response.data;
        this.usuario = null;
        this.contrasenia = null;
        this.status = this.login.status;
        this.id = this.login.id;
      });
    }
  }
}
</script>

<style>
.datos {
  text-align: right;
  margin-right: 600px;
}

.col {
  font-size: 20px;
}

.buttons {
  text-align: center;
}

.divisor {
  height: 25px;
}

.input {
  font-size: 18px;
}
</style>

