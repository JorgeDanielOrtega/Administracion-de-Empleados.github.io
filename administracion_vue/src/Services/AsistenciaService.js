const axios = require('axios');

export default class AsistenciaService {
    url = "http://localhost:8081/asistencia/"
    urlEmpresa = "http://localhost:8081/empresa/id"
    date = new Date();

    getHoraEntrada() {
        // return axios.get(this.urlEmpresa);
        return new Promise((resolve)=>{
            resolve(axios.get(this.urlEmpresa));
        });
    }

    getFecha() {
        let dia = this.date.getDate()
        dia = dia < 9 ? "0" + (dia + 1) : (dia + 1);

        let mes = (this.date.getMonth() + 1)
        mes = mes < 10 ? "0" + mes : mes;

        let anio = String(this.date.getFullYear());

        let fecha = anio + "-" + mes + "-" + dia;
        return fecha;
    }

    getHora() {
        let hora = this.date.getHours();
        let minutos = this.date.getMinutes();
        let segundos = this.date.getSeconds();

        let horaCompleta = hora + ":" + minutos + ":" + segundos;
        return horaCompleta;
    }

    getDia() {
        let dia = this.date.getDay() - 1;
        let dias = ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo']
        return dias[dia];
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