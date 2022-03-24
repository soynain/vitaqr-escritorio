/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vitaqresc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Gebel
 */
public class InfoDoctor {

    @JsonProperty
    private static String id;
    @JsonProperty
    private static String nombreCompleto;
    @JsonProperty
    private static String cargo;
    @JsonProperty
    private static String especialidad;
    @JsonProperty
    private static String dependencia;
    @JsonProperty
    private static String clinicaBase;
    @JsonProperty
    private static String consultorio;
    @JsonProperty
    private static String cedulaprofesional;
    @JsonProperty
    private static String modalidadtrabajo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getClinicaBase() {
        return clinicaBase;
    }

    public void setClinicaBase(String clinicaBase) {
        this.clinicaBase = clinicaBase;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getCedulaprofesional() {
        return cedulaprofesional;
    }

    public void setCedulaprofesional(String cedulaprofesional) {
        this.cedulaprofesional = cedulaprofesional;
    }

    public String getModalidadtrabajo() {
        return modalidadtrabajo;
    }

    public void setModalidadtrabajo(String modalidadtrabajo) {
        this.modalidadtrabajo = modalidadtrabajo;
    }

}
