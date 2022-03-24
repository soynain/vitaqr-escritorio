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
public class MedicamentosLista {
    @JsonProperty("HistorialMedicamentos")
    public List<HistorialMedicamentos> HistorialMedicamentos;

    public List<HistorialMedicamentos> getHistorialMedicamentos() {
        return HistorialMedicamentos;
    }

    public void setHistorialMedicamentos(List<HistorialMedicamentos> HistorialMedicamentos) {
        this.HistorialMedicamentos = HistorialMedicamentos;
    }
    
    
    
}
