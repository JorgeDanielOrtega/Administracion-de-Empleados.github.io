<template>
<<<<<<< HEAD
    <div class="filtro flex justify-content-center gap-4"> <!-- Class -->
        <div class="campos flex gap-2">         
            <!-- We use drop down its has label, select and options
            label creates a input and can use for for associaate with the id attribute
            select cotains two atributes : name and id (if we had used for in label the id shall have the same value it could have another
             insteresting attributes)
             option = it contains one or more options each option has it own item
             IPORTANT v-model is a form to create two-ways to connect data binding betwenn a value in our teplate and
             value in our data property-->
            <Dropdown class="dropdown" v-model="selectDepartamento" :options="departamentos" optionLabel="nombre"
                placeholder="Departamento" />
            <Dropdown class="dropdown" v-model="selectHorario" :options="horarios" optionLabel="tipo" placeholder="Horario" />
            <Dropdown class="dropdown" v-model="selectRol" :options="roles" optionLabel="nombre" placeholder="Rol" />
        </div>
        <div class="campo_texto flex gap-2">
            <!-- We sould use class in every object that we want to add -->
            <InputText id="dataUser" type="text" placeholder="Ingresa los nombres o el id" class="p-inputtext-sm"
                v-model="dataUser" />
        </div>
        <div class="buttons flex gap-2">
            <!-- Click is a avent to directional a specific action -->
            <Button label="Buscar" @click="buscar()" />
            <Button label="Limpiar" @click="limpiarBusqueda()" />
        </div>
    </div>

    <div>
        <DataTable :value="empleados" :paginator="true" :rows="10" responsiveLayout="scroll"
            :style="{ margin: '1rem' }">

            <Column field="id" header="Id"></Column>
            <Column field="nombres" header="Nombres"></Column>
            <Column field="apellidos" header="Apellidos"></Column>
            <Column field="departamento" header="Departamento"></Column>
            <Column field="horario" header="Horario"></Column>
            <Column field="rol" header="Rol"></Column>
        </DataTable>
        <!-- Router is use to bind pages-->
        <router-link to="/"> <Button label="Atras" /></router-link>
        <!-- todo cambiar el touter link, al principal cuando se haga -->
=======
    <div v-if=status>
        <div class="filtro flex justify-content-center gap-4">
            <div class="campos flex gap-2">
                <Dropdown class="dropdown" v-model="selectDepartamento" :options="departamentos" optionLabel="nombre"
                    placeholder="Departamento" />
                <Dropdown class="dropdown" v-model="selectHorario" :options="horarios" optionLabel="tipo" placeholder="Horario" />
                <Dropdown class="dropdown" v-model="selectRol" :options="roles" optionLabel="nombre" placeholder="Rol" />

            </div>
            <div class="campo_texto flex gap-2">
                <InputText id="dataUser" type="text" placeholder="Ingresa los nombres o el id" class="p-inputtext-sm"
                    v-model="dataUser" />
            </div>
            <div class="buttons flex gap-2">
                <Button label="Buscar" @click="buscar()" />
                <Button label="Limpiar" @click="limpiarBusqueda()" />
            </div>
        </div>

        <div>
            <DataTable :value="empleados" :paginator="true" :rows="10" responsiveLayout="scroll"
                :style="{ margin: '1rem' }">

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
    </div>
    <div v-else>
        <div class="divisor"></div>
        <label class="login"><b>Por favor relaice el LogIn</b></label>
        <div class="divisor"></div>
        <Button class="buttonLogin" label="LogIn" @click="redirigir()" />
>>>>>>> ffbccdb8b09493137b92efaa9ae21f08588a8f55
    </div>
</template>

<script>
import BusquedaService from "../Services/BusquedaService";
import LoginService from "../Services/LoginService"

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
            dataUser: null,
            status: null,
            idLogin: null
        }
    },
    busquedaService: null,
    loginService: null,
    created() {
        this.busquedaService = new BusquedaService();
        this.selectedList = new Map();
        this.loginService = new LoginService();
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

        this.loginService.retornarIngreso().then(response => {
            this.login = response.data;
            this.idLogin = this.login.id;
            this.status = this.login.status;
        });
    },

    methods: {
        buscar() {
            let regexOnlyNumber = /^[0-9]*$/;
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
            if (this.dataUser != null && regexOnlyNumber.test(this.dataUser)) {
                this.selectedList.set('id', this.dataUser);
            }
            else if (this.dataUser != null) {
                this.selectedList.set('nombreApellido', this.dataUser);
            }

            this.busquedaService.realizarBusqueda(this.selectedList).then(res => {
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
        },
        redirigir(){
            this.$router.push('/');
        }
    }
}

</script>

<style scoped>
.filtro{
    margin-bottom: 50px;
}

#dataUser{
    width: 300px;
}
.dropdown{
    width: 200px;
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