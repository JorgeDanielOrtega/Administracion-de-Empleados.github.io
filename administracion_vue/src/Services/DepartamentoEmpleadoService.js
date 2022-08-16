import EmpleadoService from "./EmpleadoService";

export default class DepartamentoEmpleadoService {
    empleadoService = new EmpleadoService();
    trabajadores = null
    url = "http://localhost:8081/departamento/"

    async getEmpleadosListByDepartamento(idTrabajador) {
        let idDepartamento = null
        await this.getDepartamentoByIdTrabajador(idTrabajador).then(response => {
            idDepartamento = response;
            console.log('iddepaa', idDepartamento);
        });

        return new Promise((resolve, reject) => {
            fetch(this.url + 'nombre/' + idDepartamento)
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error!!!", err);
                    reject
                });
        });
    }

    async getDepartamentoByIdTrabajador(idTrabajador) {

        await this.empleadoService.getTrabajadores().then(response => {
            this.trabajadores = response
        })


        for (let index = 0; index < this.trabajadores.length; index++) {
            if (this.trabajadores[index].id == idTrabajador) {
                console.log('departemento retorna', this.trabajadores[index].idDepartamento);
                return this.trabajadores[index].idDepartamento
            }
        }
    }
}