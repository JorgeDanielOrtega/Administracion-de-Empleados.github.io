package com.example.administracion.Models;

public enum DiasLaborales {

    DO (7), LU(1), MA(2), MI(3), JU(4), VI(5), SA(6);

    private long diaLaboral;
    
    private DiasLaborales(long diaLaboral) {
        this.diaLaboral = diaLaboral;
    }

    public long getDiaLaboral() {
        return diaLaboral;
    }



}
