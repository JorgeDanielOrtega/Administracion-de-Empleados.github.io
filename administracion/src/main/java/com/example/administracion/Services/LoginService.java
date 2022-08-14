package com.example.administracion.Services;

import com.example.administracion.Models.Login;
import com.example.administracion.Models.Trabajador;
import com.example.administracion.Repositories.LoginRepository;
import com.example.administracion.Repositories.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;

@Service
public class LoginService {

    @Autowired
    TrabajadorRepository trabajadorRepository;
    @Autowired
    LoginRepository loginRepository;

    public Login verificarDatos(Login login){
        boolean estado = false;
        ArrayList<Trabajador>  trabajadores = obtenerTrabajadores();
        for (int i = 0; i < trabajadores.size(); i++){
            if(trabajadores.get(i).getUsuario().equals(login.getUsuario())) {
                if (trabajadores.get(i).getPassword().equals(login.getContrasenia())) {
                    login.setId(trabajadores.get(i).getId());
                    estado = true;
                    break;
                }
                break;
            }
        }
        login.setStatus(estado);
        loginRepository.save(login);
        for(int g = 0; g < loginRepository.findAll().size(); g++){
            if (loginRepository.findAll().get(g).getId() != login.getId()){
                loginRepository.deleteById(loginRepository.findAll().get(g).getId());
            }
        }


        return login;
    }

    private ArrayList<Trabajador> obtenerTrabajadores(){
        ArrayList<Trabajador> trabajadorList = new ArrayList<>();
        for (int i = 0; i < trabajadorRepository.count(); i++){
            trabajadorList.add(((ArrayList<Trabajador>)(trabajadorRepository.findAll())).get(i));
        }
        return trabajadorList;
    }

    public Login cargarLogin(){
        LinkedList<Login> loginList = loginRepository.findAll();
        Login loginRetornar = new Login();
        for(int i = 0; i < loginList.size(); i++){
            if(loginList.get(i) != null){
                loginRetornar = loginList.get(i);
            }
        }
        return loginRetornar;
    }

    public Login salir(Login login){
        login.setId(login.getId());
        login.setUsuario("Usuario");
        login.setContrasenia("Contrasenia");
        login.setStatus(false);
        return loginRepository.save(login);
    }

}
