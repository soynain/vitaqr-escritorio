/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vitaqresc.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Gebel
 */
public class HistorialCitasMedica {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("fechahoracita")
    private String fechahoracita;
    @JsonProperty("motivocita")
    private String motivocita;
    @JsonProperty("idPaciente")
    private Integer idPaciente;
    @JsonProperty("idMedico")
    private Integer idMedico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechahoracita() {
        return fechahoracita;
    }

    public void setFechahoracita(String fechahoracita) {
        this.fechahoracita = fechahoracita;
    }

    public String getMotivocita() {
        return motivocita;
    }

    public void setMotivocita(String motivocita) {
        this.motivocita = motivocita;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }
}
