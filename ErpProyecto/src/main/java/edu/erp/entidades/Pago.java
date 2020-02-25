package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pago {

    
    
private int Efectivo;
private String cheques;

    public int getEfectivo() {
        return Efectivo;
    }

    public void setEfectivo(int Efectivo) {
        this.Efectivo = Efectivo;
    }

    public String getCheques() {
        return cheques;
    }

    public void setCheques(String cheques) {
        this.cheques = cheques;
    }

   


}
