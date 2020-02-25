package edu.erp.entidades;

import javax.persistence.Entity;

@Entity
public class Administrador extends User {

private Object Super;
private Object Usuario;
private Object ABM;
private Object producto;

    public Object getSuper() {
        return Super;
    }

    public void setSuper(Object Super) {
        this.Super = Super;
    }

    public Object getUsuario() {
        return Usuario;
    }

    public void setUsuario(Object Usuario) {
        this.Usuario = Usuario;
    }

    public Object getABM() {
        return ABM;
    }

    public void setABM(Object ABM) {
        this.ABM = ABM;
    }

    public Object getProducto() {
        return producto;
    }

    public void setProducto(Object producto) {
        this.producto = producto;
    }
    


    
}
