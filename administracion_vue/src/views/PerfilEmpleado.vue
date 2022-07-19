<template>
    <div>
        <!--todo quitar las clases de los input text quizas -->
        <label for="nombres">Nombres:</label>
        <InputText class="input_info" id="nombres" type="text" v-model="nombres" disabled="true" />
        <label for="apellidos">Apellidos:</label>
        <InputText class="input_info" id="apellidos" type="text" v-model="apellidos" disabled="true" />
        <label for="cedula">Cedula:</label>
        <InputText class="input_info" id="cedula" type="text" v-model="cedula" disabled="true" />
        <label for="sexo">Sexo:</label>
        <InputText class="input_info" id="sexo" type="text" v-model="sexo" disabled="true" />
        <hr>
        <label for="telefono">Telefono:</label>
        <InputText class="input_info" id="telefono" type="text" v-model="telefono" disabled="true" />
        <label for="estadoCivil">Estado Civil:</label>
        <InputText class="input_info" id="estadoCivil" type="text" v-model="estadoCivil" disabled="true" />
        <label for="ciudad">Ciudad:</label>
        <InputText class="input_info" id="ciudad" type="text" v-model="ciudad" disabled="true" />
        <label for="direccion">Direccion:</label>
        <InputText class="input_info" id="direccion" type="text" v-model="direccion" disabled="true" />
        <hr>
        <label for="correoEmpresarial">Correo Empresarial:</label>
        <InputText class="input_info" id="correoEmpresarial" type="text" v-model="correoEmpresarial" disabled="true" />
        <label for="correoPersonal">Correo Personal:</label>
        <InputText class="input_info" id="correoPersonal" type="text" v-model="correoPersonal" disabled="true" />
        <!-- <Button label="Ver horario" class="p-button-outlined" @click="openModalHorario"></Button> -->
        <router-link to="/perfil/2/asistencia"  > <Button label="Ver asistencia" class="p-button-outlined"  /></router-link>
        <!-- <Button label="Ver asistencias" class="p-button-outlined" @click=""></Button> -->

        <!-- dialog horario -->
        <Dialog header="Horario" v-model:visible="displayModalHorario"
            :breakpoints="{ '960px': '75vw', '640px': '90vw' }" :style="{ width: '50vw' }" :modal="true">
            <label for="tipo">Tipo:</label>
            <InputText class="input_info" id="tipo" type="text" v-model="tipoHorario" disabled="true" />
            <label for="diasLaborablesList">Dias Laborables:</label>
            <InputText class="input_info" id="diasLaborablesList" type="text" v-model="diasLaborablesHorarioList" disabled="true" />
            <label for="horasSemanales">Horas semanales:</label>
            <InputText class="input_info" id="horasSemanales" type="text" v-model="horasSemanalesHorario" disabled="true" />

            <template #footer>
                <Button label="Salir" icon="pi pi-check" @click="closeModalHorario" autofocus />
            </template>
        </Dialog>

        <!-- dialog asistencia -->
        <Dialog header="Asistencias" v-model:visible="displayModalAsistencia"
            :breakpoints="{ '960px': '75vw', '640px': '90vw' }" :style="{ width: '50vw' }" :modal="true">

            <template #footer>
                <Button label="Salir" icon="pi pi-check" @click="closeModalAsistencia" autofocus />
            </template>
        </Dialog>


    </div>
</template>

<script>

import PerfilService from '@/Services/PerfilService';

//aqui se crean todas las variables
export default {
    name: 'PerfilEmpleado',
    //quizas poner la propiedad en para mostrar el nombre del usuario
    data() { //datos que se van a reflejar en el <template> y los cuales, nuestra aplicacion va a manejar
        return {
            //perfil
            id : null,
            perfil: null,
            nombres: null,
            apellidos: null,
            correoEmpresarial: null,
            correoPersonal: null,
            ciudad: null,
            cedula: null,
            estadoCivil: null,
            direccion: null,
            telefono: null,
            sexo: null,

            //display
            displayModalHorario: false,
            displayModalAsistencia: false,

            //horario
            tipoHorario: null,
            diasLaborablesHorarioList: null,
            horasSemanalesHorario: null
        }
    },
    perfilService: null,
    created() { //metodo que se va a ejecutar cuando se cree el componente
        this.perfilService = new PerfilService();
    },
    mounted() { //metodo que se va a ejecutar una vez el componente este montado

        this.perfilService.getEmpleadoById(2).then(response => { //quitar el 2 y enviarlo en el body
            this.perfil = response.data;
            this.nombres = this.perfil.nombres;
            this.apellidos = this.perfil.apellidos;
            this.correoEmpresarial = this.perfil.correo_empresarial;
            this.correoPersonal = this.perfil.correo_personal;
            this.ciudad = this.perfil.ciudad;
            this.cedula = this.perfil.cedula;
            this.estadoCivil = this.perfil.estado_civil;
            this.direccion = this.perfil.direccion;
            this.telefono = this.perfil.telefono;
            this.sexo = this.perfil.sexo;
            console.log(this.perfil);
        });
    },
    methods: {
        openModalHorario() {
            this.getHorarioEmpleado(2);
            this.displayModalHorario = true;
        },
        closeModalHorario() {
            this.displayModalHorario = false;
        },
        openModalAsistencia() {
            this.displayModalAsistencia = true;
        },
        closeModalAsistencia() {
            this.displayModalAsistencia = false;
        },

        getHorarioEmpleado(id) { //todo poner id mas tarde
            this.perfilService.getHorarioEmpleadoById(id).then(response => {
                this.tipoHorario = response.data.tipo;
                this.diasLaborablesHorarioList = response.data.dias_laborables;
                this.horasSemanalesHorario = response.data.horas_semanales;
                console.log(response.data);
                console.log(this.tipoHorario);
                console.log(this.diasLaborablesHorarioList);
                console.log(this.horasSemanalesHorario);
            })
        }

    }

}
</script>


<style scoped>
/*TODO: agregarle un tipo de fuente a las label*/
* {
    text-align: left;
}

/* .perfil{
    margin-left: 50px;
} */

a{
    text-decoration: none; /* para eliminar el text decoration que genera el routerlink */
}

label {
    display: block;
    margin-bottom: 15px;
}

.input_info {
    margin-bottom: 30px;
    width: 350px;
}
</style>
