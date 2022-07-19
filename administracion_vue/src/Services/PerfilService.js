//import axios from 'axios';

const axios = require('axios');


export default class PerfilService {
    url = "http://localhost:8080/perfil/"
    totalVuePackages = null
    getEmpleadoById(id) {
        return axios.get(this.url+id);
            // .then(response => {
            //     this.totalVuePackages = response.data;
            //     console.log(this.totalVuePackages);
            // });
    }

    getHorarioEmpleadoById(id){
        return axios.get(this.url + id + "/horario");
    }

    getAsistenciasEmpleadoById(id){
        return axios.get(this.url + id + "/asistencias");
    }

    holax(){
        return axios.get(this.url + id + "/asistencias").then(res => res.json())
                .then(d => d.data);
    }
}