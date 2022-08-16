<template>
    <div v-if=status>
        <div>
            <DataTable :value="decimos" :paginator="true" :rows="10" responsiveLayout="scroll" :style="{ margin: '1rem' }">
                <Column field="NombresApellidos" header="Nombres y Apellidos"></Column>
                <Column field="decimoTercero" header="Decimo Tercero"></Column>
                <Column field="decimoCuarto" header="Decimo Cuarto"></Column>
                <Column field="fondoReserva" header="Fondo Reserva"></Column>
            </DataTable>
    <Button class="buttonLogin" label="Eliminar" @click="eliminar()" />
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

import DecimoService from "../Services/DecimoService"
import LoginService from "@/Services/LoginService";

export default {
    name: 'Decimo',
    data() {
        return {
            id: null,
            decimos: null,
            status: null,
            idLogin: null,
        }
    },
    decimoService: null,
    loginService: null,
    created() {
        this.decimoService = new DecimoService();
        this.loginService = new LoginService();
    },
    mounted() {
        this.decimoService.actualizarDecimos();
        
        this.decimoService.getDecimos().then(response => {
            this.decimos = response.data;
            console.log(this.decimos);
        });
        this.loginService.retornarIngreso().then(response => {
            this.login = response.data;
            this.idLogin = this.login.id;
            this.status = this.login.status;
        });

    },
    methods: {
        eliminar(){
            this.decimoService.deleteDecimo(111);
        },
        getId() {
            this.id = this.$route.params.id;
            return this.id;
        },
        redirigir(){
            this.$router.push('/');
        }
    }

}

</script>

<style>
a {
    text-decoration: none;
}
</style>