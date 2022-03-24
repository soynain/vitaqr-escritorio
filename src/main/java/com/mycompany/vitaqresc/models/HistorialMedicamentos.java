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
public class HistorialMedicamentos {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("dosis")
    private String dosis;
    @JsonProperty("frecuencia")
    private String frecuencia;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("idPac")
    private Integer idPac;
    @JsonProperty("fechaInicio")
    private String fechaInicio;

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("dosis")
    public String getDosis() {
        return dosis;
    }

    @JsonProperty("dosis")
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    @JsonProperty("frecuencia")
    public String getFrecuencia() {
        return frecuencia;
    }

    @JsonProperty("frecuencia")
    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("idPac")
    public Integer getIdPac() {
        return idPac;
    }

    @JsonProperty("idPac")
    public void setIdPac(Integer idPac) {
        this.idPac = idPac;
    }

    @JsonProperty("fechaInicio")
    public String getFechaInicio() {
        return fechaInicio;
    }

    @JsonProperty("fechaInicio")
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }



}
