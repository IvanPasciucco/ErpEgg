package edu.erp.entidades;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Pedidos {

private Object pedidos;
private Compra compra;
private Date FechaAutomatica;
private Empleado empleados;
private Date FechaEstimada;

    public Object getPedidos() {
        return pedidos;
    }

    public void setPedidos(Object pedidos) {
        this.pedidos = pedidos;
    }

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


    
}
