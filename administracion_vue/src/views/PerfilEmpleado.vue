<template>
    <div v-if=status>
            <div class="container grid">
            <!--todo quitar las clases de los input text quizas -->
            <div class="container__datos grid col-25 ">
                <label class="col" for="nombres">Nombres:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="nombres" type="text" v-model="nombres"
                    disabled="true" />
                <label class="col" for="apellidos">Apellidos:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="apellidos" type="text" v-model="apellidos"
                    disabled="true" />
                <label class="col" for="cedula">Cedula:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="cedula" type="text" v-model="cedula"
                    disabled="true" />
                <label class="col" for="sexo">Sexo:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="sexo" type="text" v-model="sexo" disabled="true" />
            </div>
            <div class="divider"></div>
            
            <div class="container__contacto grid col-25">
                <label class="col" for="telefono">Telefono:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="telefono" type="text" v-model="telefono"
                    disabled="true" />
                <label class="col" for="estadoCivil">Estado Civil:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="estadoCivil" type="text" v-model="estadoCivil"
                    disabled="true" />
                <label class="col" for="ciudad">Ciudad:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="ciudad" type="text" v-model="ciudad"
                    disabled="true" />
                <label class="col" for="direccion">Direccion:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="direccion" type="text" v-model="direccion"
                    disabled="true" />
            </div>
    <div class="divider"></div>
            <div class="container__datos--empresa grid col-25">
                <label class="col" for="correoEmpresarial">Correo Empresarial:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="correoEmpresarial" type="text"
                    v-model="correoEmpresarial" disabled="true" />
                <label class="col" for="correoPersonal">Correo Personal:</label>
                <InputText class="input_info p-inputtext-sm col-3" id="correoPersonal" type="text" v-model="correoPersonal"
                    disabled="true" />
            </div>


            <!-- dialog horario -->
            <Dialog header="Horario" v-model:visible="displayModalHorario"
                :breakpoints="{ '960px': '75vw', '640px': '90vw' }" :style="{ width: '50vw' }" :modal="true">
                <div class="grid">

                    <label class="col" for="tipo">Tipo:</label>
                    <InputText class="input_info--horario col-10" id="tipo" type="text" v-model="tipoHorario"
                        disabled="true" />
                    <label class="col" for="diasLaborablesList">Dias Laborables:</label>
                    <InputText class="input_info--horario col-10" id="diasLaborablesList" type="text"
                        v-model="diasLaborablesHorarioList" disabled="true" />
                    <label class="col" for="horasSemanales">Horas semanales:</label>
                    <InputText class="input_info--horario col-10" id="horasSemanales" type="text"
                        v-model="horasSemanalesHorario" disabled="true" />
                </div>


                <!-- <template #footer>
                    <Button label="Salir" icon="pi pi-check" @click="closeModalHorario" autofocus />
                </template> -->
            </Dialog>

            <!-- dialog asistencia
            <Dialog header="Asistencias" v-model:visible="displayModalAsistencia"
                :breakpoints="{ '960px': '75vw', '640px': '90vw' }" :style="{ width: '50vw' }" :modal="true">

                <template #footer>
                    <Button label="Salir" icon="pi pi-check" @click="closeModalAsistencia" autofocus />
                </template>
            </Dialog> -->

        </div>

        <div class="buttons flex justify-content-center gap-3">
            <div class="button ">
                <router-link to="/perfil/2/asistencia" class="router ">
                    <Button label="Ver asistencia" class="p-button-outlined btnAsistencia" />
                </router-link>
            </div>
            <div class="button ">
                <Button label="Ver Horario" class="p-button-outlined" @click="openModalHorario()" />
            </div>
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

import PerfilService from '@/Services/PerfilService';
import LoginService from "../Services/LoginService"

//aqui se crean todas las variables
export default {
    name: 'PerfilEmpleado',
    //quizas poner la propiedad en para mostrar el nombre del usuario
    data() { //datos que se van a reflejar en el <template> y los cuales, nuestra aplicacion va a manejar
        return {
            //login
            status: null,
            idLogin: null,

            //perfil
            id: null,
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
    loginService: null,
    created() { //metodo que se va a ejecutar cuando se cree el componente
        this.perfilService = new PerfilService();
        this.loginService = new LoginService();
    },
    mounted() { //metodo que se va a ejecutar una vez el componente este montado

        this.perfilService.getEmpleadoById(2).then(response => { //todo quitar el 2 y enviarlo en el body
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
        this.loginService.retornarIngreso().then(response => {
            this.login = response.data;
            this.idLogin = this.login.id;
            this.status = this.login.status;
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
        // openModalAsistencia() {
        //     this.displayModalAsistencia = true;
        // },
        // closeModalAsistencia() {
        //     this.displayModalAsistencia = false;
        // },

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
        },
        redirigir(){
            this.$router.push('/');
        }
    }

}
</script>


<style  scoped>
/*TODO: agregarle un tipo de fuente a las label*/
* {
    
}

.container {
    /* font-family: 'Roboto'; */
    text-align: left;
    margin-top: 50px;
    margin-right: 10px;
    margin-left: auto;
}

.divider{
    text-align: left;
    background-color: rgba(58, 58, 58, 0.158);
    width: 85%;
    height: 1px;
    margin-left: 10px;
    margin-bottom: 50px;
}


.container__datos {
    text-align: left;
    margin-bottom: 20px;
}

.container__contacto {
    text-align: left;
    margin-bottom: 20px;

}

.container__datos--empresa {
    text-align: left;
    margin-bottom: 50px;
}

.btnAsistencia {
    text-align: left;
}

.buttons {
    text-align: left;
    margin-bottom: 20px;
}

.router {
    text-align: left;
    display: flex;
    /* margin-right: 18.25rem; */

}

label {
    text-align: left;
    display: inline-block;
    width: auto;
    margin-bottom: 15px;
}

.input_info {
    text-align: left;
    margin-bottom: 30px;
    margin-right: 290px;
    width: 350px;
}

.input_info--horario {
    text-align: left;
    margin-top: 15px;
    margin-bottom: 15px;
    height: 35px;
}

.login{
    font-size: 35px;
    margin-bottom: 0px;
}

.divisor{
    height: 25px;
}

.buttonLogin{
    margin-top: 0px;
}
</style>
