<template>      
    <div>
        <Toast />
        <Menubar :model="items" />
        <DataTable :value="empleados" v-model:selection="selectedEmpleado" selectionMode="single" dataKey="id" responsiveLayout="scroll" :rows="10" >
        <!-- <DataTable :value="empleados" :paginator="true" :rows="10"  :selectionMode="single" :selection.sync="selectedEmpleado"   v-model:selection="selectedEmpleado"   dataKey="id"  > -->
            <Column field="id" header="Id"></Column>
            <Column field="nombres" header="Nombres"></Column>
            <Column field="apellidos" header="Apellidos"></Column>
            <Column field="usuario" header="Usuario"></Column>
            <Column field="cedula" header="Cedula"></Column>
            <Column field="telefono" header="Telefono"></Column>
            <Column field="departamento" header="Departamento"></Column>
            <Column field="rol" header="Rol"></Column>
            <Column field="puesto" header="Puesto"></Column>
            <Column field="horario" header="Horario"></Column>
        </DataTable>
        <Dialog header="Empleado" v-model:visible="displayModal" :breakpoints="{'960px': '75vw', '640px': '90vw'}"  :style="{width: '35vw'}"  :modal="true"> 
            
            <span class="p-float-label">
                 <InputText id="nombre" type="text" v-model="persona.nombres" style="width: 100%" />
                <label for="nombre">Nombres</label>
            </span>
            <br>

            <span class="p-float-label">
                 <InputText id="apellido" type="text" v-model="persona.apellidos" style="width: 100%" />
                <label for="apellido">Apellidos</label>
            </span>
            <br>

            <span class="p-float-label">
                 <InputText id="direccion" type="text" v-model="persona.direccion" style="width: 100%" />
                <label for="direccion">Direccion</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="estadoCivil" type="text" v-model="persona.estadoCivil" style="width: 100%"/>
                <label for="estadoCivil">Estado Civil</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="cedula" type="text" v-model="persona.cedula"  />
                <label for="cedula">Cedula</label>
            </span>
            <br><br>
                <label for="sexo">Sexo</label><br><br>
                    <input type="radio" v-model ="persona.sexo" name="sexoTrabajador" value="M">Masculino
                    <input type="radio" v-model ="persona.sexo" name="sexoTrabajador" value="F">Femenino
            <br><br>
            <br>
            <span class="p-float-label">
                 <InputText id="ciudad" type="text" v-model="persona.ciudad"  />
                <label for="ciudad">Ciudad</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="telefono" type="text" v-model="persona.telefono"  />
                <label for="telefono">Telefono</label>
            </span>
            <br>

            <label for="fechaNacimiento">Fecha de nacimiento</label>
            <br>
            <input type="date"  id="fechaNacimiento"  v-model="persona.fechaNacimiento"  />
            <br><br>
            <label for="anioEntrada">Año de entrada</label>
            <br>
             <input type="date" name="anioEntrada" min="2000-01-01"  v-model="persona.anioEntrada"  />
            <br><br>
            <span class="p-float-label">
                 <InputText id="correoPersonal" type="text" v-model="trabajador.correoPersonal"  />
                <label for="correoPersonal">Correo personal</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="correoEmpresarial" type="text" v-model="trabajador.correoEmpresarial"  />
                <label for="correoEmpresarial">Correo empresarial</label>
            </span>

            <br>
            <span class="p-float-label">
                 <InputText id="usuario" type="text" v-model="trabajador.usuario"  />
                <label for="usuario">Usuario</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="contrasenia" type="password" v-model="trabajador.password"  />
                <label for="contrasenia">Contraseña</label>
            </span>
            <br>
            <label for="tieneContrato">Pago por transferencia</label><br><br>
                    <input type="radio" v-model ="trabajador.formaPago" name="pagoPorTransferencia" value="1">Si
                    <input type="radio" v-model ="trabajador.formaPago" name="pagoPorTransferencia" value="0">No
            <br><br>
            <span class="p-float-label">
                 <InputText id="vacaciones" type="text" v-model="trabajador.vacaciones"  />
                <label for="vacaciones">Vacaciones</label>
            </span>
            <br>
            <span class="p-float-label">
                <InputText id="rol" type="text" v-model="nombreRol"  />
                <label for="rol">Rol</label>
            </span>
            <br>
            <Button label="Crear Contrato" icon="pi pi-tag" @click="mostrarModalContrato" class="p-button-text"/>
            <br>
            <br>
            <span class="p-float-label">
                 <InputText id="departamento" type="text" v-model="nombreDepartamento"  />
                <label for="pagoTransferencia">Departamento</label>
            </span>
            <br>
            <span class="p-float-label">
                 <InputText id="horario" type="text" v-model="tipoHorario"  />
                <label for="horario">Horario</label>
            </span>
            <br>

            <template #footer>
                <Button label="Guardar" icon="pi pi-check" @click="guardarEmpleadoView" />
                <Button label="Cancelar" icon="pi pi-times" @click="closeModal" class="p-button-text"/>

            </template>
         </Dialog>
        <Dialog header="Contrato" v-model:visible="displayModalContrato" :breakpoints="{'960px': '75vw', '640px': '90vw'}"  :style="{width: '35vw'}"  :modal="true"> 
                    <label for="tieneContrato">Tiene contrato</label><br><br>
                    <input type="radio" v-model ="contrato.tieneContrato" name="tieneContrato" value="1">Si
                    <input type="radio" v-model ="contrato.tieneContrato" name="tieneContrato" value="0">No
            <br><br>

            <span class="p-float-label">
                    <InputText id="tiempoContrato" type="text" v-model="contrato.tiempoContrato"  style="width: 100%" />
                    <label for="tiempoContrato">Tiempo del contrato</label>
            </span>
            <br>
            <label for="fechaLimite">Fecha limite</label>
            <br>
            <input type="date"  id="fechaLimite"  v-model="contrato.fechaLimite"  />
            <br><br>
            <template #footer>
                    <Button label="Guardar" icon="pi pi-check" @click="guardarContrato" class="p-button-text"/>
                    <Button label="Cancelar" icon="pi pi-times" @click="closeModalContrato" autofocus />
            </template>
        </Dialog>

        <!-- todo cambiar el touter link, al principal cuando se haga -->
    </div>
</template>

<script>
import EmpleadoService from "../Services/EmpleadoService";
import DecimoService from "../Services/DecimoService";

export default {
    name: ' ',

    data() {
        return {
            empleados: null,
            nombreDepartamento: null,
            nombreRol: null,
            tipoHorario: null,
            idContrato: null,
            selectedEmpleado : {
                idPersona:null,
                nombres : null,
                apellidos : null,
                direccion : null,
                estadoCivil : null, //
                cedula : null,
                sexo : null, //
                ciudad : null, //
                telefono : null,
                fechaNacimiento : null, //
                anioEntrada : null, //

                idContrato: null,//
                tieneContrato: null,//
                tiempoContrato: null,//
                fechaLimite: null,//
                id: null,
                correoPersonal : null,  
                correoEmpresarial: null, 
                vacaciones: null,
                usuario: null,
                password: null,
                formaPago : null,
                rol : null,
                departamento : null,
                horario : null,
                idTrabajador : null,
            },
            contrato : {
                id: null,
                tieneContrato: null,
                tiempoContrato: null,
                fechaLimite: null,
                idEmpleado: null,
            },
            persona : {
                id : null,
                nombres : null,
                apellidos : null,
                direccion : null,
                estadoCivil : null,
                cedula : null,
                sexo : null,
                ciudad : null,
                telefono : null,
                fechaNacimiento : null,
                anioEntrada : null,
            }, 

            trabajador  : {
                id : null,
                correoPersonal : null,
                correoEmpresarial: null,
                
                vacaciones: null,
                usuario: null,
                password: null,
                formaPago : null,
                idRol : null,
                idContrato : null,
                idDepartamento : null,
                idHorario : null,
                idPersona: null,
            },
            empleado : {
                id : null,
                idTrabajador : null,
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
                        if(this.selectedEmpleado.id == null){
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
                    label : 'Eliminar  Llaves foraneas',
                    icon : 'pi pi-key',
                    command: () => {
                        if(this.selectedEmpleado.id == null){
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
                        if(this.selectedEmpleado.id == null){
                            this.$toast.add({
                            severity:'error',
                            summary: 'AVISO',
                            detail: 'Seleccione una fila',
                            life: 3000
                            });
                        }else{
                            this.eliminar();
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
            displayModal : false,
            displayModalContrato: false
        }
    },
    empleadoService: null,
    decimoService: null,
    created() { // created at momento to execute
        this.empleadoService = new EmpleadoService();
        this.decimoService = new DecimoService();
    },
    mounted() {
        this.obtenerTodo();
    },

    methods: {
        closeModal(){
            this.displayModal =false;
            this.persona.cedula = null;
            this.persona.id=null
        },
        closeModalContrato(){
            this.displayModalContrato = false;
            this.contrato.id = null;
        },
        async mostrarEditModal(){
            console.log(this.selectedEmpleado.nombre);
            console.log("ID EMPLEADO" + this.selectedEmpleado.id);
            this.empleado.id = this.selectedEmpleado.id;
            this.persona.nombres = this.selectedEmpleado.nombres;
            this.persona.apellidos = this.selectedEmpleado.apellidos;
            this.persona.cedula = this.selectedEmpleado.cedula;
            this.persona.telefono = this.selectedEmpleado.telefono;
            this.persona.usuario = this.selectedEmpleado.usuario;
            await this.empleadoService.getPersonas().then(response => {
                response.forEach(element => {
                    if(this.persona.cedula === element.cedula){
                        this.persona.id = element.id;
                        this.trabajador.idPersona = element.id;
                        this.persona.direccion = element.direccion;
                        this.persona.estadoCivil = element.estadoCivil;
                        this.persona.sexo = element.sexo;
                        this.persona.ciudad = element.ciudad;
                        this.persona.fechaNacimiento = element.fechaNacimiento;
                        this.persona.anioEntrada = element.anioEntrada;
                        this.persona.id = element.id;
                    }
                });
            });
            await this.empleadoService.getTrabajadores().then(response => {
                response.forEach(element => {
                    if(this.persona.id === element.idPersona){
                        this.trabajador.id = element.id;
                        console.log("TRABAJADOR" + this.trabajador.id);
                        this.trabajador.correoPersonal = element.correoPersonal;
                        this.trabajador.correoEmpresarial = element.correoEmpresarial;
                        this.trabajador.usuario = element.usuario;
                        this.trabajador.password = element.password;
                        this.trabajador.formaPago = element.formaPago;
                        this.trabajador.idContrato = element.idContrato;
                    }
                });
            });
            console.log("TREEE " + this.trabajador.id);
            await this.empleadoService.getContratos().then(response => {
                response.forEach(element => {
                    if(this.trabajador.idContrato === element.id){
                        this.contrato.id = element.id;
                        this.contrato.tieneContrato = element.tieneContrato;
                        this.contrato.tiempoContrato = element.tiempoContrato;
                        this.contrato.fechaLimite = element.fechaLimite;
                        this.contrato.idEmpleado = element.idEmpleado;
                        this.contrato.id = element.id;
                    }
                });
            });
            this.nombreDepartamento = this.selectedEmpleado.departamento;
            this.nombreRol = this.selectedEmpleado.rol;

            this.tipoHorario = this.selectedEmpleado.horario;

            this.displayModal = true;

        },
        obtenerTodo(){
            this.empleadoService.getEmpleadosDataTable().then(response => {
            this.empleados = response;
        });
        },

        async guardarContrato(){
            this.contrato.idEmpleado = null;
            await this.empleadoService.guardarContrato(this.contrato).then (data => {
                console.log(data);
                this.contrato.id = data.id;
                console.log(this.contrato);
                if(data.status === 200){
                    this.displayModalContrato = false;
                }
            });
            if(this.empleado.id == null){
                this.trabajador.id =null;
                var i = 0;
                await this.empleadoService.getContratos().then (response => {
                response.forEach(element => {
                    console.log("ID ELEMENT " + element.id);
                if( i < element.id){
                    i = element.id;
                    this.contrato.id= element.id;
                    this.trabajador.idContrato = element.id;
                    console.log(" ID DE CONTRATO  " + this.contrato.id);
                    }
                 });
             });
            }else{
                this.contrato.id = this.trabajador.idContrato;
            }
             console.log(this.contrato);

        },

        async eliminar(){
            //
            console.log("CEDULA DE " + this.selectedEmpleado.cedula);
            console.log("EMPLEADO "  + this.selectedEmpleado.id);
            this.decimoService.deleteDecimo(this.selectedEmpleado.id); // para eliminar los decimos
            await this.empleadoService.getPersonas().then( response => {
                response.forEach(element => {
                    if(this.selectedEmpleado.cedula === element.cedula){
                         this.selectedEmpleado.idPersona = element.id;
                        console.log("PERSONA "  + this.selectedEmpleado.idPersona);
                    }
                });
            });
            console.log("CONTRATO "  + this.selectedEmpleado.idContrato);
            await this.empleadoService.getTrabajadores().then( response => {
                response.forEach(element => {
                    if(this.selectedEmpleado.idPersona === element.idPersona){
                        this.selectedEmpleado.idTrabajador = element.id;
                        this.selectedEmpleado.idContrato = element.idContrato;
                        console.log("TRABAJADOR "  + this.selectedEmpleado.idPersona);
                    }
                });
            });
            

            if(confirm("Esta seguro que quiere eliminar el registro?")){
                this.empleadoService.eliminarPersona(this.selectedEmpleado.idPersona);
                this.empleadoService.eliminarTrabajador(this.selectedEmpleado.idTrabajador);
                this.empleadoService.eliminarContrato(this.selectedEmpleado.idContrato); 
                this.empleadoService.eliminarEmpleado(this.selectedEmpleado.id).then(data => {
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
        async eliminarLlavesForaneas(){
            //EMPLEADO
            await this.empleadoService.getEmpleados().then( response => {
                response.forEach(element => {
                    if(this.selectedEmpleado.id === element.id){
                        this.selectedEmpleado.idTrabajador = element.idTrabajador;
                    }
                });
            });
            console.log("ID TRABAJADOR = " + this.selectedEmpleado.idTrabajador);
            await this.empleadoService.getContratos().then(response =>{
                response.forEach(element => {
                    if(this.selectedEmpleado.id === element.idEmpleado){ 
                        console.log("ID empleado = " + this.selectedEmpleado.id);
                        element.idEmpleado = null;
                        console.log("POST- ELEMENT ID = " + element.idEmpleado)
                        this.empleadoService.guardarContrato(element);
                    }
                });
            }); 
            //TRABAJADOR
            await this.empleadoService.getEmpleados().then(response => {
                response.forEach(element => {
                    if(this.selectedEmpleado.idTrabajador === element.idTrabajador){
                        console.log("ID TRABAJADOR = " + this.selectedEmpleado.idTrabajador);
                        element.idTrabajador = null,
                        console.log("POST ELEMENT ID = " + element.idTrabajador)
                        this.empleadoService.guardarEmpleado(element);
                    }
                });
            });
            await this.empleadoService.obtenerJsonAsistencias().then(response => {
                response.forEach(element => {
                    if(this.selectedEmpleado.idTrabajador === element.idTrabajador){
                        console.log("ID ASISTENCIAS = " + this.selectedEmpleado.idTrabajador);
                        element.idTrabajador = null,
                        console.log("POST ELEMENT ID = " + element.idTrabajador)
                        this.empleadoService.guardarAsistencia(element);
                    }
                });
            });

            //PERSONA

            await this.empleadoService.getTrabajadores().then( response => {
                response.forEach(element => {
                    if(this.selectedEmpleado.idTrabajador === element.id){
                        this.selectedEmpleado.idPersona = element.idPersona;
                        this.selectedEmpleado.idContrato = element.idContrato;
                         console.log("ID PERSONA = " + this.selectedEmpleado.idPersona);
                        console.log("ID CONTRATO = " + this.selectedEmpleado.idContrato);

                    }
                });
            });

            await this.empleadoService.getTrabajadores().then(response =>{
                response.forEach(element => {
                    if(this.selectedEmpleado.idPersona === element.idPersona){
                        console.log("ID persona = " + this.selectedEmpleado.idPersona);

                        element.idPersona = null;
                        element.idContrato = null;
                        console.log("POST- ELEMENT ID = " + element.idPersona + element.idContrato);
                        this.empleadoService.guardarTrabajador(element);
                    }
                });
            });
            //CONTRATO)
            // await this.empleadoService.getTrabajadores().then(response =>{
            //     response.forEach(element => {
            //         if(this.selectedEmpleado.idContrato === element.idContrato){ 
            //             console.log("ID CONTRATO = " + this.selectedEmpleado.idContrato);
            //             element.idContrato = null;
            //             console.log("POST- ELEMENT ID = " + element.idContrato)
            //             this.empleadoService.guardarTrabajador(element);
            //         }
            //     });
            // });
             this.$toast.add({
                            severity:'info',
                            summary: 'AVISO',
                            detail: 'Llaves eliminadas',
                            life: 3000
                        });

        },
        async guardarPersona(){
            await this.empleadoService.guardarPersona(this.persona).then (data => {
                console.log(data);
                if(data.status === 200){

                    this.persona = {
                        id : null, 
                        nombres: null,
                        apellidos : null,
                        direccion : null,
                        estadoCivil : null,
                        cedula : null,
                        sexo : null,
                        ciudad : null,
                        telefono : null,
                        fechaNacimiento : null,
                        anioEntrada : null,
                    }
                 }
                //  this.guardarTrabajadorView();
            });

        },
        async guardarTrabajadorView(){
            if(this.trabajador.idPersona == null){
                var i = 0;
                await this.empleadoService.getPersonas().then (response => {
                response.forEach(element => {
                    console.log("ID ELEMENT " + element.id);
                if( i < element.id){
                    i = element.id;
                    this.trabajador.idPersona= element.id;
                    console.log(" ID DE PERSONA EN TRABAJADORE  " + this.contrato.id);
                    }
                 });
             });
            }

            if(this.trabajador.idContrato == null){
                var j = 0;
                await this.empleadoService.getContratos().then (response => {
                response.forEach(element => {
                    console.log("ID ELEMENT " + element.id);
                if( j < element.id){
                    j = element.id;
                    this.contrato.id= element.id;
                    this.trabajador.idContrato = element.id;
                    console.log(" ID DE CONTRATO  " + this.contrato.id);
                    }
                 });
             });
            }else{
                console.log("ID CONTRATO = " + this.trabajador.idContrato);
            }
            
            await this.empleadoService.obtenerJsonDepartamentos().then(response => {
                response.forEach(element => {
                    if( this.nombreDepartamento === element.nombre){
                        this.trabajador.idDepartamento = element.id;
                        console.log(element.nombre + " " + this.trabajador.idDepartamento);
                    }
            });
        });
            await this.empleadoService.obtenerJsonRoles().then(response => {
            response.forEach(element => {
                if( this.nombreRol === element.nombre){
                    this.trabajador.idRol = element.id;
                    console.log(element.nombre + " " + this.trabajador.idRol);
                }
            });
        });
            await this.empleadoService.obtenerJsonHorarios().then(response => {
            response.forEach(element => {
                if( this.tipoHorario === element.tipo){
                    this.trabajador.idHorario = element.id;
                    console.log("Horario " + element.tipo + "  " + this.trabajador.idHorario);
                }
            });
        });
        console.log("POST TRABAJADOR");
            console.log(this.trabajador);
            await this.empleadoService.guardarTrabajador(this.trabajador).then (data => {
                console.log(data);
                if(data.status === 200){
                     this.guardarEmpleadoView();
                     this.trabajador = {
                            //id: null,
                            correoPersonal : null,
                            correoEmpresarial: null,
                            usuario: null,
                            vacaciones: null,
                            password: null,
                            formaPago : null,
                            idRol : null,
                            idContrato : null,
                            idDepartamento : null,
                            idHorario : null,
                            idPersona: null,
                        }
                 }
            });
        },

        async guardarEmpleadoView(){
            await this.guardarPersona();
            await this.guardarTrabajadorView();
            await this.empleadoService.getEmpleados().then( response => {
                response.forEach(element => {
                    if(this.selectedEmpleado.id === element.id){
                        this.trabajador.id = element.idTrabajador;
                        console.log("TRABAJADOR "  + this.trabajador.id);
                    }
                });
            });
            console.log("TRABAJADOR FRUE "  + this.trabajador.id);    

            if(this.trabajador.id == null){
                var i = 0;
                await this.empleadoService.getTrabajadores().then (response => {
                response.forEach(element => {
                    console.log("ID ELEMENT " + element.id);
                if( i < element.id){
                    i = element.id;
                    this.empleado.idTrabajador = element.id;
                    console.log(" ID DE TRABAJADOR  " + this.empleado.idTrabajador);
                    }
                 });
             });
            }else{
                console.log("ID TRABAJADOR ES " + this.trabajador.id);
                this.empleado.idTrabajador = this.trabajador.id;
                console.log("ID TRABAJADOR ES " + this.empleado.idTrabajador);
                console.log("SELECT EM" + this.selectedEmpleado.id);
                 this.selectedEmpleado.id = this.empleado.id;


                //this.trabajador.id = null;
            }
            

            await this.empleadoService.guardarEmpleado(this.empleado);
            console.log("EMPLEAODO ID" + this.empleado.id);
            if(this.empleado.id == null){
                var c = 0;
                await this.empleadoService.getEmpleados().then (response => {
                response.forEach(element => {
                    console.log("ID ELEMENT " + element.id);
                if( c< element.id){
                    c = element.id;
                    this.contrato.idEmpleado = element.id;
                    console.log(" ID DE CONTRATO EN TRABAJADORE  " + this.contrato.idEmpleado);
                    }
                 });
             });
            }else{
                console.log("ID EMPLEADOO" + this.empleado.id);
                this.contrato.idEmpleado = this.selectedEmpleado.id;
            }
            this.empleadoService.guardarContrato(this.contrato);
            this.empleado = {
                         id: null,
                         idTrabajador : null
            } 
            this.contrato = {
                            id : null,
                            tieneContrato: null,
                            tiempoContrato: null,
                            fechaLimite: null,
                            idEmpleado: null,
                        }
            this.$toast.add({
                            severity:'success',
                            summary: 'AVISO',
                            detail: 'Cambios Realizados',
                            life: 3000
                        });
            this.selectedEmpleado = {
                idPersona:null,
                nombres : null,
                apellidos : null,
                direccion : null,
                estadoCivil : null, //
                cedula : null,
                sexo : null, //
                ciudad : null, //
                telefono : null,
                fechaNacimiento : null, //
                anioEntrada : null, //

                idContrato: null,//
                tieneContrato: null,//
                tiempoContrato: null,//
                fechaLimite: null,//
                id: null,
                correoPersonal : null,  
                correoEmpresarial: null, 
                vacaciones: null,
                usuario: null,
                password: null,
                formaPago : null,
                rol : null,
                departamento : null,
                horario : null,
                idTrabajador : null,
            }
         this.displayModal =false; 

            await this.obtenerTodo();
        },
        mostrarModal(){
            this.displayModal = true;
        },
        mostrarModalContrato(){
            this.displayModalContrato = true;
        }
    }
    }
    </script>
<style>
    a{
        text-decoration: none;
    }
</style>