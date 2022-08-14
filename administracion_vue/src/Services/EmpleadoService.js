//import axios from "axios";

import axios from "axios";

export default class EmpleadoService{
    url = "http://localhost:8080/empleados/"
    urlDepartamentos = "http://localhost:8080/departamento/all"
    urlPuestos = "http://localhost:8080/puesto/all"
    urlRoles = "http://localhost:8080/rol/all"
    urlHorario = "http://localhost:8080/horario/all"
    urlAsistenicas = "http://localhost:8080/asistencia/"
    urlGerentes = "http://localhost:8080/gerentes/"

    //considerar el await para traer los datos rapido
    
    getEmpleados(){
        return new Promise((resolve, reject) => {
            fetch(this.url+ "table")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en EmpleadoServicee", err);
                    reject
                });
        });
    }
    getEmpleadosDataTable(){
        return new Promise((resolve, reject) => {
            fetch(this.url+ "all")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en EmpleadoServicee", err);
                    reject
                });
        });
    }

    getPersonas(){
        return new Promise((resolve, reject) => {
            fetch(this.url+ "personas")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en EmpleadoServicee", err);
                    reject
                });
        });
    }
    
    getTrabajadores(){
        return new Promise((resolve, reject) => {
            fetch(this.url+ "trabajadores")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en EmpleadoServicee", err);
                    reject
                });
        });
    }

    getContratos(){
        return new Promise((resolve, reject) => {
            fetch(this.url+ "contratos")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en EmpleadoServicee", err);
                    reject
                });
        });
    }
    
    obtenerJsonDepartamentos(){
        return new Promise((resolve, reject) => {
            fetch(this.urlDepartamentos)
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en RolService", err);
                    reject
                });
        });
    }

    obtenerJsonPuestos(){
        return new Promise((resolve, reject) => {
            fetch(this.urlPuestos)
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en RolService", err);
                    reject
                });
        });
    }
    obtenerJsonRoles(){
        return new Promise((resolve, reject) => {
            fetch(this.urlRoles)
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en RolService", err);
                    reject
                });
        });
    }
    obtenerJsonHorarios(){
        return new Promise((resolve, reject) => {
            fetch(this.urlHorario)
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en RolService", err);
                    reject
                });
        });
    }
    obtenerJsonAsistencias(){
        return new Promise((resolve, reject) => {
            fetch(this.urlAsistenicas + "all")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en RolService", err);
                    reject
                });
        });
    }
    obtenerJsonGerentes(){
        return new Promise((resolve, reject) => {
            fetch(this.urlGerentes + "all")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en RolService", err);
                    reject
                });
        });
    }
    guardarPersona(persona){
        return axios.post(this.url + "guardarPersona", persona);
    }

    guardarTrabajador(trabajador){
        return axios.post(this.url + "guardarTrabajador", trabajador);
    }

    guardarContrato(contrato){
        return axios.post(this.url + "guardarContrato", contrato);
    }
    guardarEmpleado(empleado){
        return axios.post(this.url + "guardarEmpleado", empleado);
    }
    guardarAsistencia(asistencia){
        return axios.post(this.urlAsistenicas + "guardarAsistencia", asistencia);
    }
    guardarGerente(gerente){
        return axios.post(this.urlGerentes + "guardarGerente", gerente);
    }
    eliminarPersona(id){
        return axios.get(this.url + "eliminarPersona/" + id);
    }
    eliminarTrabajador(id){
        return axios.get(this.url + "eliminarTrabajador/" + id);
    }
    eliminarEmpleado(id){
        return axios.get(this.url + "eliminarEmpleado/" + id);
    }
    eliminarContrato(id){
        return axios.get(this.url + "eliminarContrato/" + id);
    }
}