<template>
    
    <Toast position="bottom-right" />

    <div>
        <RadioButton id="presente" name="estado" value="presente" v-model="selectedValue"
            :disabled="this.activarPresente()" />
        <label for="presente">Presente</label>
        <RadioButton id="retraso" name="estado" value="retraso" v-model="selectedValue" />
        <label for="retraso">Retraso</label>
        <RadioButton id="falta_injustificada" name="estado" value="falta injustificada" v-model="selectedValue" />
        <label for="falta_injustificada">Falta Injustificada</label>

        <Button label="Enviar" @click="enviar()" />
    </div>

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
            this.asistenciaService.postAsistencia(this.getIdTrabajador(), this.selectedValue).then(res => {
                if (res.status == 200) {
                    this.showSuccess();
                }
            });
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
    }
}



</script>

<style>
</style>