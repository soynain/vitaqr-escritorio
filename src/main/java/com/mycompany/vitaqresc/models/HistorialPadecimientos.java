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

public class HistorialPadecimientos {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("gravedad")
    private String gravedad;
    @JsonProperty("causa")
    private String causa;
    @JsonProperty("fechaDiagnostico")
    private String fechaDiagnostico;
    @JsonProperty("idPac")
    private Integer idPac;

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

    @JsonProperty("gravedad")
    public String getGravedad() {
        return gravedad;
    }

    @JsonProperty("gravedad")
    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    @JsonProperty("causa")
    public String getCausa() {
        return causa;
    }

    @JsonProperty("causa")
    public void setCausa(String causa) {
        this.causa = causa;
    }

    @JsonProperty("fechaDiagnostico")
    public String getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    @JsonProperty("fechaDiagnostico")
    public void setFechaDiagnostico(String fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    @JsonProperty("idPac")
    public Integer getIdPac() {
        return idPac;
    }

    @JsonProperty("idPac")
    public void setIdPac(Integer idPac) {
        this.idPac = idPac;
    }


}
