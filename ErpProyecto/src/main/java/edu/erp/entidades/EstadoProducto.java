package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class EstadoProducto {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Object aceptado;
    private Object pendiente;
    private Object rechazado;

    @OneToOne
    private Producto producto;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
