package com.example.administracion.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horarios_dias_laborables")
public class HorariosDias_laborables {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_horarios")
    private Long idHorario;
    @Column(name = "id_dias_laborables")
    private Long idDiasLaborables;

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Long getIdDiasLaborables() {
        return idDiasLaborables;
    }

    public void setIdDiasLaborables(Long idDiasLaborables) {
        this.idDiasLaborables = idDiasLaborables;
    }

}
