<template>
    <!-- <div>
        <p>el id xd {{ hola() }}</p>
    </div> -->
    <!-- todo ponerle estilos a la tabla -->
    <div>
        <DataTable :value="asistencia" :paginator="true" :rows="10" responsiveLayout="scroll" :style="{margin: '1rem'}">
            <Column field="fecha" header="Fecha"></Column>
            <Column field="hora" header="Hora"></Column>
            <Column field="estado" header="Estado"></Column>
            <Column field="diaSemana" header="Dia"></Column>
        </DataTable>
        <router-link to="/perfil"> <Button label="Atras" icon="pi pi-check"/></router-link>
        
    </div>
</template>

<script>

import PerfilService from '@/Services/PerfilService';

export default {
    name: 'AsistenciaEmpleado',
    data() {
        return {
            elid: null,
            asistencia: null
        }
    },
    perfilService: null,
    created() {
        this.perfilService = new PerfilService();
    },
    mounted() {
        this.perfilService.getAsistenciasEmpleadoById(3).then(response => { // todo cambiar el id mas tarde
            this.asistencia = response;
        });
    },

    methods: {
        getId() { //todo quitar mas tarde quizas
            this.elid = this.$route.params.id;
            return this.elid;
        }
    }

}

</script>

<style>
    a{
        text-decoration: none;
    }
</style>