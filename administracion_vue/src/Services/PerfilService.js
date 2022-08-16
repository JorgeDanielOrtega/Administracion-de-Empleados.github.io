//import axios from 'axios';
//import fetch from 'node-fetch';
const axios = require('axios');


export default class PerfilService {
    url = "http://localhost:8081/perfil/"
    getEmpleadoById(id) {
        return axios.get(this.url + id);
    }

    getHorarioEmpleadoById(id) {
        return axios.get(this.url + id + "/horario");
    }

    getAsistenciasEmpleadoById(id) {

        return new Promise((resolve, reject) => {
            fetch(this.url + id + "/asistencias")
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error!!!", err);
                    reject
                });
        });

    }
}