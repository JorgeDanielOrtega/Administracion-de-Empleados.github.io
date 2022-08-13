const axios = require('axios');

const MESES = 12
const DIAS_LABORALES = 360
const SUELDO_BASICO = 425.0
const PORCENTAJE_FONDO_RESERVA = 0.0833




export default class AsistenciaService {
    url = "http://localhost:8081/decimo"
    urlAsistencia = "http://localhost:8081/asistencia/"
    urlEmpleado = "http://localhost:8081/"

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
