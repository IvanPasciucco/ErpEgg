package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {
@Id
    
private Object aceptado;
private Object pendiente;
private Object rechazado;

    public Object getAceptado() {
        return aceptado;
    }

    public void setAceptado(Object aceptado) {
        this.aceptado = aceptado;
    }

    public Object getPendiente() {
        return pendiente;
    }

    public void setPendiente(Object pendiente) {
        this.pendiente = pendiente;
    }

    public Object getRechazado() {
        return rechazado;
    }

    public void setRechazado(Object rechazado) {
        this.rechazado = rechazado;
    }




    
}
