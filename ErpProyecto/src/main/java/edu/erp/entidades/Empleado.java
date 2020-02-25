package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Empleado {

private String direccion;
private String Cuil;
private Object Vehiculos;
private Object Pedidos;
private Object hs;

@OneToOne
private Vehiculo vehiculo;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuil() {
        return Cuil;
    }

    public void setCuil(String Cuil) {
        this.Cuil = Cuil;
    }

    public Object getVehiculos() {
        return Vehiculos;
    }

    public void setVehiculos(Object Vehiculos) {
        this.Vehiculos = Vehiculos;
    }

    public Object getPedidos() {
        return Pedidos;
    }

    public void setPedidos(Object Pedidos) {
        this.Pedidos = Pedidos;
    }

    public Object getHs() {
        return hs;
    }

    public void setHs(Object hs) {
        this.hs = hs;
    }
    



}
