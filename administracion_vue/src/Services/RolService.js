//import axios from "axios";

import axios from "axios";

export default class RolService{
    // url = "http://localhost:8080/rol/"
    url = "http://localhost:8081/rol/"
    urlDepartamentos = "http://localhost:8080/departamento/all"
    urlPuestos = "http://localhost:8080/puesto/all"
    urlTrabajadores = "http://localhost:8080/empleados/"

    //considerar el await para traer los datos rapido
    
    getRoles(){
        //It give us a reult true or fase if ts true then will execute this
        return new Promise((resolve, reject) => {
            fetch(this.url + "all")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en RolService", err);
                    reject
                });
        });
    }
    cambiarIdTrabajador(trabajador){
        return axios.post(this.urlTrabajadores + "guardarTrabajador", trabajador);
    }
    guardarRol(rol){
        return axios.post(this.url + "guardar", rol);
    }
    eliminarRol(id){
        return axios.get(this.url + "eliminar/" + id);
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
    obtenerJsonTrabajadores(){
        return new Promise((resolve, reject) => {
            fetch(this.urlTrabajadores + "trabajadores")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en RolService", err);
                    reject
                });
        });
    }

    
//const obtenerIdPuesto =Object.freeze({ Active: 1, Inactive: 2 });
    // obtenerIdPuesto: async  nombrePuesto () {
    //     return new Promise((resolve, reject) => {
    //         if(this.puestos.find(puesto => puesto.nombre === nombrePuesto)){
    //                 resolve(puesto.id);
    //             }else{
    //                 reject("El puesto no existe");
    //                 }
    //             }) 
    // }
        

    // obtenerDepartamento(){
    //     const response = fetch(this.urlDepartamentos);
    //     const json = response.json();
    //     console.log(json);
    // }

    // obtenerId(nombreDepartamento){
    //     // eslint-disable-next-line no-undef
    //     for (nombre in this.urlPuestos.nombre){
    //         // eslint-disable-next-line no-undef
    //         if(nombre === nombreDepartamento){
    //             alert(this.urlDepartamentos.id);
    //         }
    //     }
    // }
    // postRoles(idR, nombre, salario, idP, idD){
    //     let rol = {
    //         idRol: idR,
    //         nombreRol: nombre,
    //         salario: salario,
    //         idPuesto: idP,
    //         idDepartamento: idD
    //     }
    //     return axios.post(this.url + idR, rol);
    // }

    

}
