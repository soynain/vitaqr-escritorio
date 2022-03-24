/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vitaqresc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Gebel
 */

public class ListaCitasPaciente {
      @JsonProperty("HistorialCitasMedicas")
    private List<HistorialCitasMedica> HistorialCitasMedicas;

    public List<HistorialCitasMedica> getHistorialCitasMedicas() {
        return HistorialCitasMedicas;
    }

    public void setHistorialCitasMedicas(List<HistorialCitasMedica> HistorialCitasMedicas) {
        this.HistorialCitasMedicas = HistorialCitasMedicas;
    }

}
