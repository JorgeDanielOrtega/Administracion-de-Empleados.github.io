
package com.example.administracion.Controllers;

import com.example.administracion.Models.Login;
import com.example.administracion.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public Login cargarLogin(){
        return loginService.cargarLogin();
    }

    @PostMapping("/salir")
    public Login salir(@RequestBody Login login){
        return loginService.salir(login);
    }

    @PostMapping("/logear")
    public Login verificarLogin(@RequestBody Login login){
        Login login1 = loginService.verificarDatos(login);
        this.cargarLogin();
        return login1;
    }

}
