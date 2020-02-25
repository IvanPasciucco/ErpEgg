package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehiculo {
    
private Object TipoDeVehiculo;
private Object MarcaModelo;
private Object Capacidad;
private Object patente;

    public Object getTipoDeVehiculo() {
        return TipoDeVehiculo;
    }

    public void setTipoDeVehiculo(Object TipoDeVehiculo) {
        this.TipoDeVehiculo = TipoDeVehiculo;
    }

    public Object getMarcaModelo() {
        return MarcaModelo;
    }

    public void setMarcaModelo(Object MarcaModelo) {
        this.MarcaModelo = MarcaModelo;
    }

    public Object getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(Object Capacidad) {
        this.Capacidad = Capacidad;
    }

    public Object getPatente() {
        return patente;
    }

    public void setPatente(Object patente) {
        this.patente = patente;
    }

    


    
}
