<template>  
        <div v-if=status>

            <div class="titulo">
                <h1>DATOS EMPRESA</h1>
            </div>
            <div v-if="idLogin!=1">
                <div class="datos">
                    <label class="col" for="nombre">Nombre:</label>
                    <InputText class="input" id="nombre" type="text" v-model="nombre" disabled="true"/>
                    <div class="divisor"></div>
                    <label class="col" for="fundacionYear">Año fundacion:</label>
                    <InputText class="input" id="fundacionYear" type="text" v-model="fundacionYear" disabled="true" />
                    <div class="divisor"></div>
                    <label class="col" for="rubro">Rubro:</label>
                    <InputText class="input" id="rubro" type="text" v-model="rubro"  disabled="true" />
                    <div class="divisor"></div>
                    <label class="col" for="leyenda">Leyenda:</label>
                    <InputText class="input" id="leyenda" type="text" v-model="leyenda" disabled="true" /> 
                </div>
            </div>
            <div v-else>
                <div class="datos">
                    <label class="col" for="nombre">Nombre:</label>
                    <InputText class="input" id="nombre" type="text" v-model="nombre"/>
                    <div class="divisor"></div>
                    <label class="col" for="fundacionYear">Año fundacion:</label>
                    <InputText class="input" id="fundacionYear" type="text" v-model="fundacionYear"/>
                    <div class="divisor"></div>
                    <label class="col" for="rubro">Rubro:</label>
                    <InputText class="input" id="rubro" type="text" v-model="rubro"/>
                    <div class="divisor"></div>
                    <label class="col" for="leyenda">Leyenda:</label>
                    <InputText class="input" id="leyenda" type="text" v-model="leyenda"/> 
                </div>
                <div class="buttons">
                    <div class="divisor"></div>
                    <Button class="swal2-confirm swal2-styled" label="Actualizar" @click="actualizar()" />
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
import EmpresaService from "@/Services/EmpresaService";
import LoginService from "@/Services/LoginService";


export default {
    name: "empresa",
    data() {
        return {
            nombre: null,
            fundacionYear: null,
            rubro: null,
            leyenda: null,
            status: null,
            idLogin: null,
        };
    },
    empresaService: null,
    loginService: null,
    created() {
        this.empresaService = new EmpresaService();
        this.loginService = new LoginService();
    },
    mounted() {
        this.empresaService.cargarEmpresa().then(response => {
            this.empresa = response.data;
            this.nombre = this.empresa.nombre;
            this.fundacionYear = this.empresa.fundacionYear;
            this.rubro = this.empresa.rubro;
            this.leyenda = this.empresa.leyenda;
        });
        this.loginService.retornarIngreso().then(response => {
            this.login = response.data;
            this.idLogin = this.login.id;
            this.status = this.login.status;
        });
    },
    methods: {
        actualizar() {
            this.empresaService.cargarEmpresa().then(response => { this.empresa = response.data; });
            if (this.nombre != this.empresa.nombre) {
                this.empresa.nombre = this.nombre;
            }
            if (this.fundacionYear != this.empresa.fundacionYear) {
                this.empresa.fundacionYear = this.fundacionYear;
            }
            if (this.rubro != this.empresa.rubro) {
                this.empresa.rubro = this.rubro;
            }
            if (this.leyenda != this.empresa.leyenda) {
                this.empresa.leyenda = this.leyenda;
            }
            this.empresaService.actualizarEmpresa(this.empresa).then();
        },
        redirigir(){
            this.$router.push('/');
        }
    }
}
</script>

<style>
.datos{
    text-align: right;
    margin-right: 600px;
}

.col{
    font-size: 20px;
}

.buttons{
    text-align: center;
}

.divisor{
    height: 25px;
}

.input{
    font-size: 18px;
}

Button{
    margin-top: 3.125rem;
    width: 150px;
}

.login{
    font-size: 35px;
}

.buttonLogin{
    margin-top: 0px;
}

</style>