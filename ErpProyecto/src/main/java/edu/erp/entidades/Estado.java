package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estado {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String aceptado;
    private String pendiente;
    private String rechazado;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAceptado() {
        return aceptado;
    }

    public void setAceptado(String aceptado) {
        this.aceptado = aceptado;
    }

    public String getPendiente() {
        return pendiente;
    }

    public void setPendiente(String pendiente) {
        this.pendiente = pendiente;
    }

    public String getRechazado() {
        return rechazado;
    }

    public void setRechazado(String rechazado) {
        this.rechazado = rechazado;
    }

  

}
