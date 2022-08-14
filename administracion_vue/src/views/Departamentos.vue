<template>

    <div>
        <Toast />
        <Menubar :model="items" />
        <DataTable :value="departamentos" v-model:selection="selectedDepartamento" selectionMode="single" dataKey="id" responsiveLayout="scroll" :rows="10" >
            <Column field="id" header="Id"></Column>
            <Column field="nombre" header="Nombre"></Column>
            <Column field="numero" header="Numero"></Column>
            <Column field="empleadosMaximos" header="Maximo Empleados"></Column>
            <Column field="vacaciones" header="Vacaciones"></Column>
        </DataTable>
        <Dialog header="Crear Departamento" v-model:visible="displayModal" :breakpoints="{'960px': '75vw', '640px': '90vw'}"  :style="{width: '35vw'}"  :modal="true"> 

            <span class="p-float-label">
                 <InputText id="nombre" type="text" v-model="departamento.nombre"  style="width: 100%" />
                <label for="nombre">Nombre</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="numero" type="text" v-model="departamento.numero" style="width: 100%" />
                <label for="numero">Numero</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="maximoEmpleados" type="text" v-model="departamento.empleadosMaximos" style="width: 100%" />
                <label for="maximoEmpleados">Maximo Empleados</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="vacaciones" type="text" v-model="departamento.vacaciones" style="width: 100%"/>
                <label for="vacaciones">Vacaciones</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="nombreEmpresa" type="text" v-model="nombreEmpresa"  />
                <label for="nombreEmpresa">Nombre empresa</label>
            </span>
            <br>
            <template #footer>
                <Button label="Guardar" icon="pi pi-times" @click="guardar" class="p-button-text"/>
                <Button label="Cancelar" icon="pi pi-check" @click="closeModal" autofocus />
            </template>
         </Dialog>
         <router-link to="/perfil"> <Button label="Perfil" /></router-link>
        <!-- todo cambiar el touter link, al principal cuando se haga -->
    </div>
</template>

<script>
import DepartamentoService from "../Services/DepartamentoService.js";

export default {
    name: 'Departamentos',
    data() {
        return {
            departamentos: null,
            empresas: null,
            nombreEmpresa: null,
            departamento : {
                id: null,
                nombre : null,
                numero : null,
                empleadosMaximos : null,
                vacaciones : null,
                idEmpresa: null
            },
            selectedDepartamento : {
                id: null,
                nombre : null,
                numero : null,
                empleadosMaximos : null,
                vacaciones : null,
                idEmpresa: null
            },
            items : [
                {
                    label : 'Nuevo',
                    icon : 'pi pi-fw pi-plus',
                    command : () => {
                        this.mostrarModal();
                    } 
                },
                {
                    label : 'Editar',
                    icon : 'pi pi-fw pi-pencil',
                    command: () => {
                        this.mostrarEditModal();
                    }
                },
                {
                    label : 'Eliminar  Llaves foraneas',
                    icon : 'pi pi-key',
                    command: () => {
                        this.eliminarLlavesForaneas();
                    }
                },
                {
                    label : 'Eliminar',
                    icon : 'pi pi-fw pi-trash',
                    command:  () => {
                        this.eliminarDepartamento();
                    }
                },
                {
                    label: 'Refrescar',
                    icon : 'pi pi-fw pi-refresh',
                    command: () => {
                        this.obtenerTodo();
                    }
                }
            ],
            displayModal : false 
        }
    },

    departamentoService: null,
    created() { // created at momento to execute
        this.departamentoService = new DepartamentoService();
    },

    mounted() {
        this.obtenerTodo();
    },
    methods: {

        mostrarModal(){
            this.displayModal = true;
        }, 
        eliminarLlavesForaneas(){
            this.departamentoService.getJsonTrabajadores().then(response =>{
                response.forEach(element => {
                    if(this.selectedDepartamento.id === element.idDepartamento)
                        element.idDepartamento = null;
                        console.log("POST- ELEMENT ID = " + element.idDepartamento)
                        this.departamentoService.cambiarLlaveForaneaTrabajador(element);
                });
            });
            this.departamentoService.getJsonRoles().then(response =>{
                response.forEach(element => {
                    if(this.selectedDepartamento.id === element.idDepartamento)
                        element.idDepartamento = null;
                        console.log("POST- ELEMENT ID = " + element.idDepartamento);
                        this.departamentoService.cambiarLlaveForaneaRoles(element);
                });
            });
        },
        obtenerTodo(){
            this.departamentoService.getDepartamentos().then(response => {
            this.departamentos = response;
        });
        },
        mostrarEditModal(){
            this.departamento = this.selectedDepartamento;
            this.departamentoService.getJsonEmpresas().then(response => {
            this.empresas = response;
            response.forEach(element => {
                if( this.selectedDepartamento.idEmpresa === element.id){
                    this.nombreEmpresa = element.nombre;
                }
            });
         });
            this.displayModal = true;
        },
        eliminarDepartamento(){
            if(confirm("Esta seguro que quiere eliminar el registro?")){
                this.departamentoService.eliminarDepartamento(this.selectedDepartamento.id).then(data => {
                    if(data.status === 200){
                        this.$toast.add({
                            severity: 'success',
                            summary: 'AVISO',
                            detail: 'Se elimino el departamento correctamente',
                            life: 3000
                        })
                        this.obtenerTodo();
                    }
                })
            }
        },
        guardar(){
            this.departamento.idEmpresa = 1; //CORREGIR
            
        //     this.departamentoService.getJsonEmpresas().then(response => {
        //     this.empresas = response;
        //     response.forEach(element => {
        //         //console.log(element.nombre);
        //         if( this.nombreEmpresa === element.nombre){
        //             this.departamento.idEmpresa = element.id;
        //             console.log(this.departamento.idEmpresa + " " + element.nombre);
        //         }
        //     });
        // });
        console.log(this.departamento);
            this.departamentoService.guardar(this.departamento).then (data => {
                console.log(data);
                if(data.status === 200){
                    this.displayModal = false;
                    this.departamento = {
                        id: null,
                        nombre : null,
                        numero : null,
                        maximoEmpleados : null,
                        vacaciones : null,
                        idEmpresa: null
                    }
                    this.obtenerTodo();
                }
            });
        },
        closeModal(){
            this.displayModal =false;
        },
    }
    }
    </script>
<style>
    a{
        text-decoration: none;
    }
</style>>