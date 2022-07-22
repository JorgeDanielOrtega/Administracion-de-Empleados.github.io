<template>
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
</template>

<script>

import DepartamentoEmpleadoService from "../Services/DepartamentoEmpleadoService";
export default {

    name: 'DepartamentoEmpleado',
    data() {
        return {
            empleados: null
        }
    },
    departamentoService: null,

    created() {
        this.departamentoService = new DepartamentoEmpleadoService();
    },
    mounted() {
        this.departamentoService.getEmpleadosListByDepartamento(1).then(response => { //todo cambiar el id mas tarde
            console.log(response);
            this.empleados = response;
        });
    }
}
</script>

<style>
    a{
        text-decoration: none;
    }
</style>