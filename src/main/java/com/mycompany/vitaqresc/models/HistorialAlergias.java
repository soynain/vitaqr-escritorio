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
public class HistorialAlergias {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("reaccion")
    private String reaccion;
    @JsonProperty("idPac")
    private Integer idPac;
    @JsonProperty("sintomas")
    private String sintomas;
    @JsonProperty("fechaDiagnostico")
    private String fechaDiagnostico;


    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("reaccion")
    public String getReaccion() {
        return reaccion;
    }

    @JsonProperty("reaccion")
    public void setReaccion(String reaccion) {
        this.reaccion = reaccion;
    }

    @JsonProperty("idPac")
    public Integer getIdPac() {
        return idPac;
    }

    @JsonProperty("idPac")
    public void setIdPac(Integer idPac) {
        this.idPac = idPac;
    }

    @JsonProperty("sintomas")
    public String getSintomas() {
        return sintomas;
    }

    @JsonProperty("sintomas")
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @JsonProperty("fechaDiagnostico")
    public String getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    @JsonProperty("fechaDiagnostico")
    public void setFechaDiagnostico(String fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }


}
