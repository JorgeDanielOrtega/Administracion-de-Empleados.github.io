<template>

    <div>
        <Toast />
        <Menubar :model="items" />
        <DataTable :value="roles" v-model:selection="selectedRol" selectionMode="single" dataKey="id" responsiveLayout="scroll" >
            <Column field="id" header="Id"></Column>
            <Column field="nombre" header="Nombre"></Column>
            <Column field="salario" header="Salario"></Column>
        </DataTable>


        <Dialog header="Rol" v-model:visible="displayModal" :breakpoints="{'960px': '75vw', '640px': '90vw'}"  :style="{width: '35vw'}"  :modal="true"> 

            <span class="p-float-label">
                 <InputText id="nombre" type="text" v-model="rol.nombre"  style="width: 100%" />
                <label for="nombre">Nombre</label>
            </span>
            <br>
            <div class="field col-12 md:col-3">
                <label for="salario">Salario</label>
                <InputNumber inputId="salario" v-model="rol.salario" showButtons mode="currency" currency="USD"  :minFractionDigits="2" :maxFractionDigits="2"/>
            </div>
            <span class="p-float-label">
                 <InputText id="puesto" type="text" v-model="nombrePuesto" style="width: 100%" />
                <label for="puesto"> Puesto</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="departamento" type="text" v-model="nombreDepartamento" style="width: 100%" />
                <label for="departamento"> Departamento</label>
            </span>
            <template #footer>
               <!-- <Button label="Relacionar" icon="pi pi-times" @click="relacionarTablas" autofocus /> -->
                <Button label="Guardar" icon="pi pi-check" @click="guardar"  />
                <Button label="Cancelar" icon="pi pi-times" @click="closeModal" class="p-button-text" />
            </template>
         </Dialog> 
        <!-- todo cambiar el touter link, al principal cuando se haga -->
    </div>
</template>

<script>
import RolService from "../Services/RolService";

export default {
    name: 'Roles',
    data() {
        return {
            roles: null,
            departamentos: null,
            puestos: null,
            nombrePuesto: null,
            nombreDepartamento: null,
            idPuesto : null,
            idDepartamento : null,
            rol : {
                id: null,
                nombre: null,
                salario: null,
                puesto : null,
                idPuesto : null,
                idDepartamento : null,  
            },
            selectedRol : {
                id: null,
                nombre: null,
                salario: null,
                puesto : null,
                idPuesto : null,
                idDepartamento : null,  
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
                    command : () => {
                        if(this.selectedRol.nombre == null){
                            this.$toast.add({
                            severity:'error',
                            summary: 'AVISO',
                            detail: 'Seleccione una fila',
                            life: 3000
                            });
                        }else{
                            this.mostrarEditModal();
                        }
                    }
                },

                {
                    label : 'Eliminar relaciones',
                    icon : 'pi pi-key',
                    command: () => {
                        if(this.selectedRol.nombre == null){
                            this.$toast.add({
                            severity:'error',
                            summary: 'AVISO',
                            detail: 'Seleccione una fila',
                            life: 3000
                            });
                        }else{
                        this.eliminarLlavesForaneas();
                        }
                    }
                },

                {
                    label : 'Eliminar',
                    icon : 'pi pi-fw pi-trash',
                    command: () => {
                        if(this.selectedRol.nombre == null){
                            this.$toast.add({
                            severity:'error',
                            summary: 'AVISO',
                            detail: 'Seleccione una fila',
                            life: 3000
                            });
                        }else{
                        this.eliminarRol();
                        }
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
    rolService: null,
    created() { // created at momento to execute
        this.rolService = new RolService();
    },
    mounted() {
        this.obtenerTodo();
    },
    methods: {
        async relacionarTablas(){
            await this.rolService.obtenerJsonPuestos().then(response => {
            this.puestos = response;
            response.forEach(element => {
                if( this.nombrePuesto === element.nombre){
                    this.rol.idPuesto = element.id;
                    console.log(this.rol.idPuesto + " " + element.nombre);
                }
            });
        });
            await this.rolService.obtenerJsonDepartamentos().then(response => {
            this.departamentos = response;
            response.forEach(element => {
                if( this.nombreDepartamento === element.nombre){
                    this.rol.idDepartamento = element.id;
                    console.log(element.nombre + " " + this.rol.idDepartamento);
                }
            });
        });
        },
        eliminarLlavesForaneas(){
            this.rolService.obtenerJsonTrabajadores().then(response =>{
                response.forEach(element => {
                    if(this.selectedRol.id === element.idRol){ 
                        element.idRol = null;
                        console.log("POST- ELEMENT ID = " + element.idRol)
                        this.rolService.cambiarIdTrabajador(element);
                    }
                });
            });
            this.$toast.add({
                            severity:'info',
                            summary: 'AVISO',
                            detail: 'Relaciones eliinadas',
                            life: 3000
                        });
        },
         mostrarModal(){
            this.displayModal = true;
        }, 
        obtenerTodo(){
            this.rolService.getRoles().then(response => {
            this.roles = response;
            });
        },
        mostrarEditModal(){
            this.rol = this.selectedRol;
            this.rolService.obtenerJsonPuestos().then(response => {
            response.forEach(element => {
                if( this.selectedRol.idPuesto === element.id){
                    this.nombrePuesto= element.nombre;
                }
            });
        });
            this.rolService.obtenerJsonDepartamentos().then(response => {
            response.forEach(element => {
                if( this.selectedRol.idDepartamento === element.id){
                    this.nombreDepartamento= element.nombre;
                }
            });
            this.displayModal = true;
        });
        },
        // eliminar(){

        // },
        eliminarRol(){
            if(confirm("Esta seguro que quiere eliminar el registro?")){
                console.log("ID DE SELECTED ROL ES " + this.selectedRol.id);
                this.rolService.eliminarRol(this.selectedRol.id).then(data => { 
                    if(data.status === 200){
                        this.$toast.add({
                            severity:'success',
                            summary: 'AVISO',
                            detail: 'Se elimino el rol correctamento',
                            life: 3000
                            });
                        this.obtenerTodo();
                    }
                });
            }
        },
        async guardar(){
            await this.relacionarTablas()
            await this.rolService.guardarRol(this.rol).then (data => {                
                    if(data.status === 200){
                        this.obtenerTodo();
                        this.displayModal = false;
                        this.rol = {
                            id: null,
                            nombre: null,
                            salario: null,
                            puesto : null,
                            idPuesto : null,
                            idDepartamento : null,
                        }
                        this.$toast.add({
                            severity:'success',
                            summary: 'AVISO',
                            detail: 'Cambios Realizados',
                            life: 3000
                        });
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

