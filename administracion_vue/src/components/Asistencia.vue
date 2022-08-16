<template>
    <div v-if=status>
        <Toast position="bottom-right" />
        <div class="container flex justify-content-center ">
            <div class="grid container_options flex align-content-center">
                <div class="presente col-4">
                    <RadioButton  id="presente" name="estado" value="presente" v-model="selectedValue"
                        :disabled="this.activarPresente()" />
                    <label class="col-2" for="presente">Presente</label>
                </div>
                <div class=" retraso col-4">

                    <RadioButton  id="retraso" name="estado" value="retraso" v-model="selectedValue" />
                    <label class="col-2" for="retraso">Retraso</label>
                </div>
                <div class="falta_injustificada col-4">
                    <RadioButton  id="falta_injustificada" name="estado" value="falta injustificada"
                        v-model="selectedValue" />
                    <label class="col-2" for="falta_injustificada">Falta Injustificada</label>
                </div>
            </div>
        </div>
        <Button label="Enviar" @click="enviar()" />
    </div>
    <div v-else>
        <div class="divisor"></div>
        <label class="login"><b>Por favor relaice el LogIn</b></label>
        <div class="divisor"></div>
        <Button class="buttonLogin" label="LogIn" @click="redirigir()" />
    </div>
</template>

<script>

import AsistenciaService from "../Services/AsistenciaService";
import LoginService from "../Services/LoginService"

export default {
    name: 'Aistencia',
    data() {
        return {
            selectedValue: null,
            idTrabajador: null,
            horaEntrada: null,
            status: null,
            idLogin: null
        }
    },
    asistenciaService: null,
    loginService: null,
    created() {
        this.asistenciaService = new AsistenciaService();
        this.loginService = new LoginService();
    },
    mounted() {
        this.loginService.retornarIngreso().then(response => {
            this.login = response.data;
            this.idLogin = this.login.id;
            this.status = this.login.status;
        });
    },
    methods: {
        async yaMarcoAsistencia(){
            let marco = await this.asistenciaService.yaMarcoAsistencia(this.getIdTrabajador())
            return marco
        },
        getIdTrabajador() {
            this.idTrabajador = this.$route.params.id;
            return this.idTrabajador;
        },
        enviar() {
            if (this.selectedValue != null && !this.yaMarcoAsistencia()) {
                
                this.asistenciaService.postAsistencia(this.getIdTrabajador(), this.selectedValue).then(res => {
                    if (res.status == 200) {
                        this.showSuccess();
                    }
                });
            } else if(this.yaMarcoAsistencia()){
                this.showErrorAlredyAsistencia();
            }
            else {
                this.showErrorInvalidAsistencia();
                
            }
            this.selectedValue = null;
        },
        activarPresente() {
            let horaActual = this.asistenciaService.getHora();
            let hora = horaActual.substring(0, 2);
            let minutos = horaActual.substring(3, 5);
            let horaEntrada = '07';
            let minutosEntrada = '30';
            return !(hora == horaEntrada && (minutosEntrada >= minutos && minutos < minutosEntrada + 10));
        },
        showSuccess() {
            this.$toast.add({ severity: 'success', summary: 'Asistencia enviada', life: 2000 });
        },
         showErrorInvalidAsistencia() {
            this.$toast.add({severity:'error', summary: 'No se ha marcado un estado', life: 2000});
        },
        showErrorAlredyAsistencia() {
            this.$toast.add({severity:'error', summary: 'Ya se ha marcado la asistencia', life: 2000});
        },
        redirigir(){
            this.$router.push('/');
        }
    }
}



</script>

<style scoped>
.container{
    margin-top: 1.875rem;
    height: 15.625rem;
}
.container_options{
    width: 43.75rem;
    border-radius: 5px;
}

Button{
    margin-top: 3.125rem;
    width: 150px;
}

.login{
    font-size: 35px;
}

.divisor{
    height: 25px;
}

.buttonLogin{
    margin-top: 0px;
}
</style>