export default class DepartamentoEmpleadoService{
    url = "http://localhost:8081/departamento/"

    //considerar el await para traer los datos rapido

    getEmpleadosListByDepartamento(id){
        return new Promise((resolve, reject) => {
            fetch(this.url + id)
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