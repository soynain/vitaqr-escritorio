/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vitaqresc.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Gebel
 */
public class ListaPacientes {

    /**
     *
     */
    @JsonProperty("ListaPacientesJava")
    public List<ListaPacientesJava>ListaPacientesJava;

    public List<ListaPacientesJava> getListaPacientesJava() {
        return ListaPacientesJava;
    }

    public void setListaPacientes(List<ListaPacientesJava> ListaPacientesJava) {
        this.ListaPacientesJava = ListaPacientesJava;
    }

    
    
    
}
