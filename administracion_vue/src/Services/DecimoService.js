const axios = require('axios');

const MESES = 12
const DIAS_LABORALES = 360
const SUELDO_BASICO = 425.0
const PORCENTAJE_FONDO_RESERVA = 0.0833




import EmpleadoService from "./EmpleadoService";
import RolService from "./RolService";
export default class AsistenciaService {

    empleadoService = new EmpleadoService();
    rolService = new RolService();

    url = "http://localhost:8081/decimo"
    urlAsistencia = "http://localhost:8081/asistencia/"
    urlEmpleado = "http://localhost:8081/empleados/"
    decimos = null
    roles = null
    trabajadores = null


    async actualizarDecimos(){
        
        let empleados = null
        

        await this.getDecimos().then(response=>{
            this.decimos = response.data//funciona
        })
        console.log('d', this.decimos);

        await this.empleadoService.getEmpleados().then(response=>{
            empleados = response

            console.log('r', response);
        })

        await this.rolService.getRoles().then(response=>{
            this.roles = response
            console.log('roles', this.roles);
        })

        await this.empleadoService.getTrabajadores().then(response=>{
            this.trabajadores = response
            console.log('trabajadores', this.trabajadores);
        })

        empleados.forEach(empleado => {
            if (empleado.idTrabajador != null) {
                if (this.idEmpleadoDiferente(empleado.id)) {
                    // console.log(empleado.idTrabajador);
                    console.log(empleado.idTrabajador, this.getSalario(this.getIdRol(empleado.idTrabajador)));
                    this.saveDecimo(empleado.idTrabajador, this.getSalario(this.getIdRol(empleado.idTrabajador)))
                }
            }
        });
    }

    getIdRol(idTrabajador){
        for (let index = 0; index < this.trabajadores.length; index++) {
            if (this.trabajadores[index].id == idTrabajador) {
                return this.trabajadores[index].idRol
            }
        }
    }
    
    getSalario(idRol){
        for (let index = 0; index < this.roles.length; index++) {
            if (this.roles[index].id == idRol) {
                return this.roles[index].salario
            }
        }
    }

    idEmpleadoDiferente(idEmpleado){
        for (let index = 0; index < this.decimos.length; index++) {
            if (this.decimos[index].idEmpleado != idEmpleado) {
                return true
            }
        }
    }

   getDecimos() { 
        return new Promise((resolve) => {
            resolve(axios.get(this.url));
        });
    }

    async saveDecimo(idTrabajador, salario) {
        let id = 0
        let totalAsistencias = 0;
        await this.getAsistenciaByIdTrabajador(idTrabajador).then(response =>{
            totalAsistencias = response.data.length
        });
        const decimoCuarto = (SUELDO_BASICO / DIAS_LABORALES) * totalAsistencias;

        await this.getIdEmpleado(idTrabajador).then(response=>{
            id = response.data.id
        });

        let decimo = {
            decimoTercero: this.calcularDecimoTercero(salario),
            decimoCuarto: decimoCuarto,
            fondoReserva: this.calcularFondoReserva(salario),
            idEmpleado: id
        }

        return axios.post(this.url, decimo);
    }



    calcularDecimoTercero(salario) {
        return salario / MESES;
    }

    calcularFondoReserva(salario) {
        return salario * PORCENTAJE_FONDO_RESERVA;
    }

    getIdEmpleado(idTrabajador) {
        return new Promise((resolve) => {
            resolve(axios.get(this.urlEmpleado + idTrabajador));
        });
    }

    getAsistenciaByIdTrabajador(idTrabajador) {
        return new Promise((resolve) => {
            resolve(axios.get(this.urlAsistencia + idTrabajador));
        });
    }


    postAsistencia(idA, estadoA) {
        //?Nota: El json se deben de llenar conforme a los parametros de la clase Asistencia que esta en spring, y no con los parametros de la base de datos
        let asistencia = {
            idTrabajador: idA,
            fecha: this.getFecha(),
            hora: this.getHora(),
            estado: estadoA,
            diaSemana: this.getDia()
        }
        return axios.post(this.url + idA, asistencia);
    }


}
