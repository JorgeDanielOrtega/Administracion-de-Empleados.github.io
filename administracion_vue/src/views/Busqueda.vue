<template>
    <div>
        <Dropdown v-model="selectDepartamento" :options="departamentos" optionLabel="nombre"
            placeholder="Departamento" />
        <Dropdown v-model="selectHorario" :options="horarios" optionLabel="tipo" placeholder="Horario" />
        <Dropdown v-model="selectRol" :options="roles" optionLabel="nombre" placeholder="Rol" />

    </div>
    <div>
        <InputText id="dataUser" type="text" placeholder="Ingresa los nombres o el id" class="p-inputtext-sm"
            v-model="dataUser" />
        <Button label="Buscar" @click="buscar()" />
        <Button label="Limpiar" @click="limpiarBusqueda()" />
    </div>

    <div>
        <DataTable :value="empleados" :paginator="true" :rows="10" responsiveLayout="scroll"
            :style="{ margin: '1rem' }" >
            <Column field="id" header="Id"></Column>
            <Column field="nombres" header="Nombres"></Column>
            <Column field="apellidos" header="Apellidos"></Column>
            <Column field="departamento" header="Departamento"></Column>
            <Column field="horario" header="Horario"></Column>
            <Column field="rol" header="Rol"></Column>
        </DataTable>
        <router-link to="/"> <Button label="Atras" /></router-link>
        <!-- todo cambiar el touter link, al principal cuando se haga -->

    </div>
</template>

<script>
import BusquedaService from "../Services/BusquedaService";

export default {
    name: 'Busqueda',
    data() {
        return {
            empleados: null,
            roles: null,
            horarios: null,
            departamentos: null,
            selectDepartamento: null,
            selectHorario: null,
            selectRol: null,
            selectedList: null,
            dataUser: null
        }
    },
    busquedaService: null,
    created() {
        this.busquedaService = new BusquedaService();
        this.selectedList = new Map()
    },
    mounted() {
        this.busquedaService.getEmpleados().then(response => {
            this.empleados = response;
        });

        this.busquedaService.getDepartamentos().then(response => {
            this.departamentos = response;
        });

        this.busquedaService.getRoles().then(response => {
            this.roles = response;
        });

        this.busquedaService.getHorarios().then(response => {
            this.horarios = response;
        });

    },

    methods: {
        buscar() {
             this.selectedList.clear();
            if (this.selectDepartamento != null) {
                this.selectedList.set('departamento', this.selectDepartamento.nombre)
            }
            if (this.selectHorario != null) {
                this.selectedList.set('horario', this.selectHorario.tipo);
            }
            if (this.selectRol != null) {
                this.selectedList.set('rol', this.selectRol.nombre);
            }

            this.busquedaService.realizarBusqueda(this.selectedList).then(res => {
                console.log(res);
                this.empleados = res;
            });
        },
        
        limpiarBusqueda() {
            this.selectDepartamento = null;
            this.selectHorario = null;
            this.selectRol = null;
            this.dataUser = null;
            this.selectedList.clear();
            this.busquedaService.getEmpleados().then(response => {
            this.empleados = response;
        });
        }

    }
}

</script>

<style>
a {
    text-decoration: none;
}
</style>