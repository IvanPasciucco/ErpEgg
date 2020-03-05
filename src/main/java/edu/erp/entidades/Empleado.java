package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Empleado {

@Id
@GeneratedValue (generator="uuid")
@GenericGenerator(name= "uuid", strategy = "uuid2")
private String Cuil;
private String direccion;

@OneToOne
private Vehiculo Vehiculos;

@OneToOne
private Pedidos Pedidos;

@OneToOne
private Vehiculo vehiculo;

    public String getCuil() {
        return Cuil;
    }

    public void setCuil(String Cuil) {
        this.Cuil = Cuil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Vehiculo getVehiculos() {
        return Vehiculos;
    }

    public void setVehiculos(Vehiculo Vehiculos) {
        this.Vehiculos = Vehiculos;
    }

    public Pedidos getPedidos() {
        return Pedidos;
    }

    public void setPedidos(Pedidos Pedidos) {
        this.Pedidos = Pedidos;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
