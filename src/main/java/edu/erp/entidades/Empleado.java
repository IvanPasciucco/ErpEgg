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
private String Vehiculos;
private String Pedidos;
private int hs;
private Compra compra;

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

    public String getVehiculos() {
        return Vehiculos;
    }

    public void setVehiculos(String Vehiculos) {
        this.Vehiculos = Vehiculos;
    }

    public String getPedidos() {
        return Pedidos;
    }

    public void setPedidos(String Pedidos) {
        this.Pedidos = Pedidos;
    }

    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }

   
    



}
