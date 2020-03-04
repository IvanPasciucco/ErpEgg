package edu.erp.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Empleado {

@Id
private String Cuil;
private List<Pedidos> Pedidos;
private int hs;

@OneToOne
private Vehiculo vehiculo;

    public String getCuil() {
        return Cuil;
    }

    public void setCuil(String Cuil) {
        this.Cuil = Cuil;
    }

    public List<Pedidos> getPedidos() {
        return Pedidos;
    }

    public void setPedidos(List<Pedidos> Pedidos) {
        this.Pedidos = Pedidos;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }

   
    



}
