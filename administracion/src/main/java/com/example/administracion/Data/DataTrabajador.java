package com.example.administracion.Data;

public enum DataTrabajador {
    ID_TRABAJADOR("trabajador"),
    NOMBRES("persona"), APELLIDOS("persona"), CEDULA("persona"), DIRECCION("persona"), ESTADO_CIVIL("persona"),
    CIUDAD("persona"), TELEFONO("persona"), SEXO("persona"), FECHA_NACIMIENTO("persona"), ANIO_ENTRADA("persona"),
    CORREO_PERSONAL("trabajador"), CORREO_EMPRESARIAL("trabajador"), USUARIO("trabajador"), CONTRASENIA("trabajador"),
    PAGO_POR_TRANSFERENCIA("trabajador"), ID_PERSONA("trabajador"), ID_DEPARTAMENTO("trabajador"), ID_ROL("trabajador"),
    ID_HORARIO("trabajador"), VACACIONES("trabajador");

    private String tipo;

    private DataTrabajador(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}