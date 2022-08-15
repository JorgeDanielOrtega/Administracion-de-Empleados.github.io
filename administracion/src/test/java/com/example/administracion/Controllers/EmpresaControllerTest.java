package com.example.administracion.Controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

import org.checkerframework.checker.units.qual.A;
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

        when(empresaService.getEmpresaById()).thenReturn(Optional.of(empresa));

        Empresa empresaResult = empresaController.getEmpresaById();

        verify(empresaService, times(1)).getEmpresaById();
    }

    @Test
    public void obtenerEmpresas(){
        ArrayList<Empresa> empresaArrayList = new ArrayList<>();

        when(empresaService.obtenerEmpresas()).thenReturn(empresaArrayList);

        ArrayList<Empresa> empresasArrayListResult = empresaController.obtenerEmpresas();

        verify(empresaService, times(1)).obtenerEmpresas();
    }

    @Test
    public void obtenerEmpesaId(){
        Empresa empresa = new Empresa();

        when(empresaService.obtenerEmpresaId(anyLong())).thenReturn(Optional.of(empresa));

        Empresa empresaResult = empresaController.obtenerEmpresaId(anyLong()).get();

        verify(empresaService, times(1)).obtenerEmpresaId(anyLong());
    }

    @Test
    public void actualizarEmpresaDb(){
        Empresa empresa = new Empresa();

        when(empresaService.actualizarEmpresa(empresa)).thenReturn(empresa);

        Empresa empresaResult = empresaController.actualizarEmpresaDb(empresa);

        verify(empresaService, times(1)).actualizarEmpresa(empresa);
    }

    @Test
    public void getHoraEntredaEmpresa(){
        Time hora = new Time(1l);

        when(empresaService.getHoraEntredaEmpresa()).thenReturn(hora);

        Time horaResult = empresaController.getHoraEntredaEmpresa();

        verify(empresaService, times(1)).getHoraEntredaEmpresa();
    }
}