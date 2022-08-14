//import axios from "axios";

import axios from "axios";
//import { reject } from "core-js/fn/promise";

export default class DepartamentoService{
    url = "http://localhost:8080/departamento/"
    urlEmpresa = "http://localhost:8080/empresa/"
    urlRoles = "http://localhost:8080/rol/"
    urlTrabajador = "http://localhost:8080/empleados/"

    //considerar el await para traer los datos rapido

    getJsonTrabajadores(){
        return new Promise((resolve, reject) => {
            fetch(this.urlTrabajador + "trabajadores")
                .then((res ) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en DepartamentoService", err);
                    reject
                });
        });
    }
    getJsonRoles(){
        return new Promise((resolve, reject) => {
            fetch(this.urlRoles + "all")
                .then((res ) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en DepartamentoService", err);
                    reject
                });
        });
    }
    getDepartamentos(){
        return new Promise((resolve, reject) => {
            fetch(this.url + "all")
                .then((res ) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error en DepartamentoService", err);
                    reject
                });
        });
    }

    getJsonEmpresas(){
        return new Promise((resolve, reject) => {
            fetch(this.urlEmpresa + "all")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Error al ingresar en empresa ",  err);
                    reject
                });
        });
    }
    eliminarDepartamento(id){
        return axios.get(this.url + "eliminar/" + id);
    }
    guardar(departamento){
        return  axios.post(this.url + "guardar", departamento);
    }
    cambiarLlaveForaneaTrabajador(trabajador){
        return axios.post(this.urlTrabajador + "guardarTrabajador", trabajador);
    }
    cambiarLlaveForaneaRoles(rol){
        return axios.post(this.urlRoles + "guardar", rol);
    }

 }