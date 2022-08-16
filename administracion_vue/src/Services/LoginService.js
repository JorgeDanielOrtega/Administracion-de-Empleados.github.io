const axios = require('axios');

export default class LoginService {
    url = "http://localhost:8081/logear"
    urlDatos = "http://localhost:8081/login"
    urlSalir = "http://localhost:8081/salir"

    verificarIngreso(nomUsuario, contrasenia){
        let login = {
            usuario: nomUsuario,
            contrasenia: contrasenia,
            status: false,
            id: null,
        }
        return axios.post(this.url, login);
    }

    retornarIngreso(){
        return axios.get(this.urlDatos);
    }

    salir(login){
        return axios.post(this.urlSalir, login);
    }

}
