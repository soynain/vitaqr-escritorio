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
public class AlergiasLista {
    @JsonProperty("HistorialAlergias")
    public List<HistorialAlergias>HistorialAlergias;

    public List<HistorialAlergias> getHistorialAlergias() {
        return HistorialAlergias;
    }

    public void setHistorialAlergias(List<HistorialAlergias> HistorialAlergias) {
        this.HistorialAlergias = HistorialAlergias;
    }
    
    
}
