package com.example.administracion.Models;

public enum DiasLaborales {

    DO (7), LU(1), MA(2), MI(3), JU(4), VI(5), SA(6);
    private int diaLaboral;
    
    private DiasLaborales(int diaLaboral) {
        this.diaLaboral = diaLaboral;
    }

    public int getDiaLaboral() {
        return diaLaboral;
    }

}
