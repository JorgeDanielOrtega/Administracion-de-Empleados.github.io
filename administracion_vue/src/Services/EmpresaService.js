const axios = require('axios');

export default class EmpresaService {
    //url = "http://localhost:8080/empresa";
    url2 = "http://localhost:8081/empresa";

    cargarEmpresa(){
        return axios.get(this.url2); //todo cambiar a url
    }

    actualizarEmpresa(nuevaEmpresa){
        let empresaActualizada = {
            id: nuevaEmpresa.id,
            idGerente: nuevaEmpresa.idGerente,
            nombre: nuevaEmpresa.nombre,
            leyenda: nuevaEmpresa.leyenda,
            fundacionYear: nuevaEmpresa.fundacionYear,
            rubro: nuevaEmpresa.rubro,
            horaEntrada: nuevaEmpresa.horaEntrada,
            gerente: nuevaEmpresa.gerente
        }
        return axios.post(this.url2 + "/actualizar", empresaActualizada); //todo cambiar a url
    }
}
