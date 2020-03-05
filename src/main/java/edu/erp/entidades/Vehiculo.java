package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String TipoDeVehiculo;
    private String MarcaModelo;
    private int Capacidad;
    private String patente;
    
    @OneToOne
    private Empleado empleado;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoDeVehiculo() {
        return TipoDeVehiculo;
    }

    public void setTipoDeVehiculo(String TipoDeVehiculo) {
        this.TipoDeVehiculo = TipoDeVehiculo;
    }

    public String getMarcaModelo() {
        return MarcaModelo;
    }

    public void setMarcaModelo(String MarcaModelo) {
        this.MarcaModelo = MarcaModelo;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

   
}
