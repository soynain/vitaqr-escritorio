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
public class ListaPacientesJava {
    @JsonProperty
    private String idPrim;
    @JsonProperty
    private String nombres;
    @JsonProperty
    private String apellidos;
    @JsonProperty
    private String usuario;
    @JsonProperty
    private String userpass;
    @JsonProperty
    private String idPulsera;
    @JsonProperty
    private String fechaNac;
    @JsonProperty
    private String sexo;
    @JsonProperty
    private String altura;
    @JsonProperty
    private Integer peso;
    @JsonProperty
    private Long numTelefono;
    @JsonProperty
    private Integer idDoctor;
    @JsonProperty
    private String donanteorg;

    public String getDonanteorg() {
        return donanteorg;
    }

    public void setDonanteorg(String donanteorg) {
        this.donanteorg = donanteorg;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getIdPulsera() {
        return idPulsera;
    }

    public void setIdPulsera(String idPulsera) {
        this.idPulsera = idPulsera;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Long getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(Long numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getIdPrim() {
        return idPrim;
    }

    public void setIdPrimr(String idPrimr) {
        this.idPrim = idPrim;
    }

}
