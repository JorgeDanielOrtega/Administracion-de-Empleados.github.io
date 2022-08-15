package com.example.administracion.Services;

import com.example.administracion.Models.Login;
import com.example.administracion.Repositories.LoginRepository;
import com.example.administracion.Repositories.TrabajadorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LoginServiceTest {

    @Mock
    private LoginRepository loginRepository;

    @Mock
    private TrabajadorRepository trabajadorRepository;

    @InjectMocks
    private LoginService loginService;

    private Login login;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        login = new Login();
    }

    @Test
    void verificarDatos() {
        LinkedList<Login> loginLinkedList = new LinkedList<>();
        when(loginRepository.findAll()).thenReturn(loginLinkedList);
        assertNotNull(loginService.verificarDatos(login));
    }

    @Test
    void cargarLogin() {
        LinkedList<Login> loginLinkedList = new LinkedList<>();
        when(loginRepository.findAll()).thenReturn(loginLinkedList);
        assertNotNull(loginService.cargarLogin());
    }

    @Test
    void salir() {
        when(loginService.salir(login)).thenReturn(login);
        assertNotNull(loginService.salir(login));
    }
}