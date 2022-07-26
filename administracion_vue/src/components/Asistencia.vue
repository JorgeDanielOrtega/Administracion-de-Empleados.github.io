<template>

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

</template>

<script>

import AsistenciaService from "../Services/AsistenciaService";

export default {
    name: 'Aistencia',
    data() {
        return {
            selectedValue: null,
            idTrabajador: null,
            horaEntrada: null
        }
    },
    asistenciaService: null,
    created() {
        this.asistenciaService = new AsistenciaService();
    },
    mounted() {

    },
    methods: {
        getIdTrabajador() { //todo quitar mas tarde quizas
            this.idTrabajador = this.$route.params.id;
            return this.idTrabajador;
        },
        enviar() {
            if (this.selectedValue != null) {
                
                this.asistenciaService.postAsistencia(this.getIdTrabajador(), this.selectedValue).then(res => {
                    if (res.status == 200) {
                        this.showSuccess();
                    }
                });
            } else {
                this.showError();
                
            }
            this.selectedValue = null;
        },
        activarPresente() {
            //Todo mejorar el codigo de esta funcion
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
         showError() {
            this.$toast.add({severity:'error', summary: 'No se ha marcado un estado', life: 2000});
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
    background-color: aqua;
}

Button{
    margin-top: 3.125rem;
    width: 150px;
}


</style>