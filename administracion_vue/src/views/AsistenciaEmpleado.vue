<template>
    <!-- <div>
        <p>el id xd {{ hola() }}</p>
    </div> -->
    <div>
        <DataTable :value="asistencia" :paginator="true" :rows="10"
            paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
            :rowsPerPageOptions="[10, 20, 50]" responsiveLayout="scroll"
            currentPageReportTemplate="Showing {first} to {last} of {totalRecords}">
            <Column field="diaSemana" header="Dia"></Column>
            <Column field="fecha" header="Fecha"></Column>
            <Column field="hora" header="Hora"></Column>
            <Column field="estado" header="Estado"></Column>
            <template #paginatorstart>
                <Button type="button" icon="pi pi-refresh" class="p-button-text" />
            </template>
            <template #paginatorend>
                <Button type="button" icon="pi pi-cloud" class="p-button-text" />
            </template>
        </DataTable>
    </div>
</template>

<script>

import PerfilService from '@/Services/PerfilService';

export default {
    name: 'AsistenciaEmpleado',
    data() {
        return {
            elid: null,
            fecha: null,
            hora: null,
            estado: null,
            diaSemana: null,
            asistencia: null
        }
    },
    perfilService: null,
    created() {
        this.perfilService = new PerfilService();
    },
    mounted() {
        this.perfilService.getAsistenciasEmpleadoById(3).then(response => {
            this.fecha = response.fecha;
            this.hora = response.hora;
            this.estado = response.estado;
            this.dia = response.diaSemana;
            this.asistencia = response;
            console.log(response);
        });
    },

    methods: {
        hola() {
            this.elid = this.$route.params.id;
            return this.elid;
        }
    }

}

</script>