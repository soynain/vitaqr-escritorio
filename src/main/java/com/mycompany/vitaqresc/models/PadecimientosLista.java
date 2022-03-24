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
public class PadecimientosLista {
    @JsonProperty("HistorialPadecimientos")
    public List<HistorialPadecimientos>HistorialPadecimientos;

    public List<HistorialPadecimientos> getHistorialPadecimientos() {
        return HistorialPadecimientos;
    }

    public void setHistorialPadecimientos(List<HistorialPadecimientos> HistorialPadecimientos) {
        this.HistorialPadecimientos = HistorialPadecimientos;
    }
    
}
