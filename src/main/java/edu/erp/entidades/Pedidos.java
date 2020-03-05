package edu.erp.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pedidos {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    private Compra compra;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaAutomatica;
    
    @OneToOne
    private Empleado empleados;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaEstimada;
    
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Date getFechaAutomatica() {
        return FechaAutomatica;
    }

    public void setFechaAutomatica(Date FechaAutomatica) {
        this.FechaAutomatica = FechaAutomatica;
    }

    public Empleado getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado empleados) {
        this.empleados = empleados;
    }

    public Date getFechaEstimada() {
        return FechaEstimada;
    }

    public void setFechaEstimada(Date FechaEstimada) {
        this.FechaEstimada = FechaEstimada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getPedidos() {
//        return pedidos;
//    }
//
//    public void setPedidos(String pedidos) {
//        this.pedidos = pedidos;
//    }
    
    

}
