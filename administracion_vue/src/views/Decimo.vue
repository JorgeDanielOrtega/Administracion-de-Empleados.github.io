<template>
    <div>
        <DataTable :value="decimos" :paginator="true" :rows="10" responsiveLayout="scroll" :style="{ margin: '1rem' }">
            <Column field="NombresApellidos" header="Nombres y Apellidos"></Column>
            <Column field="decimoTercero" header="Decimo Tercero"></Column>
            <Column field="decimoCuarto" header="Decimo Cuarto"></Column>
            <Column field="fondoReserva" header="Fondo Reserva"></Column>
        </DataTable>
<Button class="buttonLogin" label="Eliminar" @click="eliminar()" />
    </div>
</template>

<script>

import DecimoService from "../Services/DecimoService"

export default {
    name: 'Decimo',
    data() {
        return {
            id: null,
            decimos: null
        }
    },
    decimoService: null,
    created() {
        this.decimoService = new DecimoService();
    },
    mounted() {
        this.decimoService.actualizarDecimos();
        
        this.decimoService.getDecimos().then(response => {
            this.decimos = response.data;
            console.log(this.decimos);
        });

    },
    methods: {
        eliminar(){
            this.decimoService.deleteDecimo(111);
        },
        getId() {
            this.id = this.$route.params.id;
            return this.id;
        }
    }

}

</script>

<style>
a {
    text-decoration: none;
}
</style>