/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vitaqresc.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author Gebel
 */
public class Doctor {
    @JsonProperty
    private InfoDoctor InfoDoctor;

    public InfoDoctor getInfodoctor() {
        return InfoDoctor;
    }

    public void setInfodoctor(InfoDoctor infodoctor) {
        this.InfoDoctor = infodoctor;
    }

    
    
    
}
