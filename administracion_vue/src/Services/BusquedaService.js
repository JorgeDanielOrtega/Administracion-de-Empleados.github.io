

export default class BusquedaService {
    url = "http://localhost:8080/busqueda"
    urlRol = "http://localhost:8080/rol"
    urlDepartamento = "http://localhost:8080/departamento/nombres"
    urlHorario = "http://localhost:8080/horario"




    getEmpleados() {
        return new Promise((resolve) => {
            fetch(this.url)
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error!!!", err);
                });
        });
    }

    getDepartamentos() {
        return new Promise((resolve) => {
            fetch(this.urlDepartamento)
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error!!!", err);
                });
        });
    }

    getRoles() {
        return new Promise((resolve) => {
            fetch(this.urlRol)
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error!!!", err);
                });
        });
    }

    getHorarios() {
        return new Promise((resolve) => {
            fetch(this.urlHorario)
                .then((res) => {
                    resolve(res.json());
                })
                .catch((err) => {
                    console.log("Fetch Error!!!", err);
                });
        });
    }

}
