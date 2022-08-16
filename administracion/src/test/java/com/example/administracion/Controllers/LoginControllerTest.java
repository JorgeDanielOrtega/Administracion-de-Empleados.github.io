package com.example.administracion.Controllers;

import com.example.administracion.Models.Login;
import com.example.administracion.Services.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginService loginService;

    private Login login = new Login();

    @Test
    void cargarLogin() {
        when(loginService.cargarLogin()).thenReturn(login);

        Login loginResult = loginController.cargarLogin();

        verify(loginService, times(1)).cargarLogin();
    }

    @Test
    void salir() {
        when(loginService.salir(login)).thenReturn(login);

        Login loginResult = loginController.salir(login);

        verify(loginService, times(1)).salir(login);
    }

    @Test
    void verificarLogin() {
        when(loginService.verificarDatos(login)).thenReturn(login);

        Login loginResult = loginController.verificarLogin(login);

        verify(loginService, times(1)).verificarDatos(login);
    }
}