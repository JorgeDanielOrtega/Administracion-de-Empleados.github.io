<template>
    <!-- todo ponerle estilos a la tabla -->
    <div>
        <DataTable :value="asistencia" :paginator="true" :rows="10" responsiveLayout="scroll"
            :style="{ margin: '1rem' }">
            <Column field="fecha" header="Fecha"></Column>
            <Column field="hora" header="Hora"></Column>
            <Column field="estado" header="Estado"></Column>
            <Column field="diaSemana" header="Dia"></Column>
        </DataTable>
        <a :href="generarLink"> <Button label="Atras" class="p-button-outlined btnAsistencia" /></a>

    </div>
</template>

<script>

import PerfilService from '@/Services/PerfilService';
// import LoginService from "../Services/LoginService"

export default {
    name: 'AsistenciaEmpleado',
    data() {
        return {
            //login
            // status: null,
            // idLogin: null,

            id: null,
            asistencia: null
        }
    },
    // loginService: null,
    perfilService: null,
    created() {
        this.perfilService = new PerfilService();
        // this.loginService = new LoginService();
    },
    mounted() {
        // this.loginService.retornarIngreso().then(response => {
        //     this.login = response.data;
        //     this.idLogin = this.login.id;
        //     this.status = this.login.status;
        // });
        
        this.perfilService.getAsistenciasEmpleadoById(this.getId()).then(response => {
            this.asistencia = response;
        });
    },
    computed: {
        generarLink() {
            return `http://localhost:8082/#/perfil/${this.getId()}`
        }
    },

    methods: {
        getId() {
            this.id = this.$route.params.id;
            return this.id;
        }
    }

}

</script>

<style>
a {
    text-decoration: none;
}
</style>