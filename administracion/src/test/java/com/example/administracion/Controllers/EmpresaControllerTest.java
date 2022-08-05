package com.example.administracion.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Time;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.administracion.Models.Empresa;
import com.example.administracion.Services.EmpresaService;

@ExtendWith(MockitoExtension.class)
public class EmpresaControllerTest {

    @InjectMocks
    private EmpresaController empresaController;

    @Mock
    EmpresaService empresaService;

    @Test
    public void getEmpresaById() {
        Empresa empresa = new Empresa();

        when(empresaService.getEmpresaById()).thenReturn(empresa);

        Empresa empresaResult = empresaController.getEmpresaById();

        verify(empresaService, times(1)).getEmpresaById();
    }

    @Test
    public void getHoraEntredaEmpresa(){
        Time hora = new Time(1l);

        when(empresaService.getHoraEntredaEmpresa()).thenReturn(hora);

        Time horaResult = empresaController.getHoraEntredaEmpresa();

        verify(empresaService, times(1)).getHoraEntredaEmpresa();
    }
}