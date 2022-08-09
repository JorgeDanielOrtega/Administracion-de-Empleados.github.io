<template>
    <div v-if=status>
        <div>
            <DataTable :value="empleados" :paginator="true" :rows="10" responsiveLayout="scroll" :style="{margin: '1rem'}">
                <Column field="nombres" header="Nombres"></Column>
                <Column field="apellidos" header="Apellidos"></Column>
                <Column field="Horario" header="Horario"></Column>
                <Column field="Rol" header="Rol"></Column>
            </DataTable>
            <router-link to="/"> <Button label="Atras" /></router-link> 
            <!-- todo cambiar el touter link, al principal cuando se haga -->
        </div>
    </div>
    <div v-else>
        <div class="divisor"></div>
        <label class="login"><b>Por favor relaice el LogIn</b></label>
        <div class="divisor"></div>
        <Button class="buttonLogin" label="LogIn" @click="redirigir()" />
    </div>
</template>

<script>

import DepartamentoEmpleadoService from "../Services/DepartamentoEmpleadoService";
import LoginService from "../Services/LoginService"

export default {

    name: 'DepartamentoEmpleado',
    data() {
        return {
            empleados: null,
            status: null,
            idLogin: null
        }
    },
    departamentoService: null,
    loginService: null,
    created() {
        this.departamentoService = new DepartamentoEmpleadoService();
        this.loginService = new LoginService();
    },
    mounted() {
        this.departamentoService.getEmpleadosListByDepartamento(1).then(response => { //todo cambiar el id mas tarde
            console.log(response);
            this.empleados = response;
        });
        this.loginService.retornarIngreso().then(response => {
            this.login = response.data;
            this.idLogin = this.login.id;
            this.status = this.login.status;
        });
    }, 
    methods: {
        redirigir(){
            this.$router.push('/');
        }
    }
}
</script>

<style>
    a{
        text-decoration: none;
    }

    .login{
    font-size: 35px;
    }

    .divisor{
        height: 25px;
    }

    .buttonLogin{
        margin-top: 0px;
    }
</style>