package com.example.administracion.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.administracion.Models.Persona;
import com.example.administracion.Models.Trabajador;

public class JSON {
    private Map<String, Object> myMap;
    private List<DataTrabajador> dataTrabajadorList;
    private Persona persona;
    private Trabajador trabajador;

    private static JSON json = new JSON();

    private JSON() {
    }

    // public JSON(Map<String, Object> map, Persona persona, Trabajador trabajador)
    // {
    // this.myMap = map;
    // this.persona = persona;
    // this.trabajador = trabajador;
    // }

    public static JSON getInstance() {
        return json;
    }

    private void construirMapTrabajador(DataTrabajador preferencia) {
        switch (preferencia) {
            case CORREO_EMPRESARIAL:
                myMap.put("correo_empresarial", trabajador.getCorreoEmpresarial());
                break;
            case CORREO_PERSONAL:
                myMap.put("correo_personal", trabajador.getCorreoPersonal());
                break;
            case USUARIO:
                myMap.put("usuario", trabajador.getUsuario());
                break;
            case CONTRASENIA:
                myMap.put("contrasenia", trabajador.getPassword());
                break;
            case ID_DEPARTAMENTO:
                myMap.put("id_departamento", trabajador.getIdDepartamento());
                break;
            case ID_HORARIO:
                myMap.put("id_horario", trabajador.getIdHorario());
                break;
            case ID_PERSONA:
                myMap.put("id_persona", trabajador.getIdPersona());
                break;
            case ID_ROL:
                myMap.put("id_rol", trabajador.getIdRol());
                break;
            case ID_TRABAJADOR:
                myMap.put("id", trabajador.getId());
                break;
            case VACACIONES:
                myMap.put("vacaciones", trabajador.getVacaciones());
                break;
            case PAGO_POR_TRANSFERENCIA:
                myMap.put("pago_por_transferencia", trabajador.isPagoPorTrasferencia());
                break;
            default:
                break;
        }
    }

    private void construirMapPersona(DataTrabajador preferencia) {
        switch (preferencia) {
            case NOMBRES:
                myMap.put("nombres", persona.getNombre());
                break;
            case APELLIDOS:
                myMap.put("apellidos", persona.getApellido());
                break;
            case CEDULA:
                myMap.put("cedula", persona.getCedula());
                break;
            case DIRECCION:
                myMap.put("direccion", persona.getDireccion());
                break;
            case ESTADO_CIVIL:
                myMap.put("estado_civil", persona.getEstadoCivil());
                break;
            case TELEFONO:
                myMap.put("telefono", persona.getTelefono());
                break;
            case SEXO:
                myMap.put("sexo", String.valueOf(persona.getSexo()));
                break;
            case CIUDAD:
                myMap.put("ciudad", persona.getCiudad());
                break;
            case FECHA_NACIMIENTO:
                myMap.put("fecha_nacimiento", persona.getFechaNacimiento().toString());
                break;
            case ANIO_ENTRADA:
                myMap.put("anio_entrada", persona.getAnioEntrada().toString());
                break;
            default:
                break;
        }
    }

    public Map<String, Object> contruirMap(Iterable<DataTrabajador> dataTrabajadorIterable) {
        myMap = new HashMap<>();
        
        myMap.clear();
        dataTrabajadorIterable.forEach(preferencia -> {
            if (preferencia.getTipo().equals("trabajador")) {
                construirMapTrabajador(preferencia);
            } else {
                construirMapPersona(preferencia);
            }
        });
        // dataTrabajadorList.clear();

        return myMap;
    }

    public Map<String, Object> getMapDefault() {
        dataTrabajadorList = new LinkedList<>();
        dataTrabajadorList.add(DataTrabajador.NOMBRES);
        dataTrabajadorList.add(DataTrabajador.APELLIDOS);
        dataTrabajadorList.add(DataTrabajador.CEDULA);
        dataTrabajadorList.add(DataTrabajador.SEXO);
        dataTrabajadorList.add(DataTrabajador.ESTADO_CIVIL);
        dataTrabajadorList.add(DataTrabajador.TELEFONO);
        dataTrabajadorList.add(DataTrabajador.CIUDAD);
        dataTrabajadorList.add(DataTrabajador.CORREO_PERSONAL);
        dataTrabajadorList.add(DataTrabajador.CORREO_EMPRESARIAL);
        dataTrabajadorList.add(DataTrabajador.USUARIO);
        dataTrabajadorList.add(DataTrabajador.CONTRASENIA);
        dataTrabajadorList.add(DataTrabajador.DIRECCION);

        return contruirMap((Iterable<DataTrabajador>) dataTrabajadorList);
    }

    public Map<String, Object> getMyMap() {
        return myMap;
    }

    // public void setMyMap(Map<String, Object> myMap) {
    //     this.myMap = myMap;
    // }

    public List<DataTrabajador> getDataTrabajadorList() {
        return dataTrabajadorList;
    }

    public void setDataTrabajadorList(List<DataTrabajador> dataTrabajadorList) {
        this.dataTrabajadorList = dataTrabajadorList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

}
