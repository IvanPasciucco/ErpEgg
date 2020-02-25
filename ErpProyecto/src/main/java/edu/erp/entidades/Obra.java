package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Obra extends Cliente{
    
  private int CP;
  private String zona;
  
    @ManyToOne
    private Cliente cliente;
    
    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
  
    
    
}
