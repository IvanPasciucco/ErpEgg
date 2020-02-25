package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Producto extends Proveedor {

private int id;
private int PrecioBase;
private Object stock;
private Object ProveedorOpcional;
private String NombreProducto;
private Object descuento;

@ManyToOne
private Proveedor proveedor;

@ManyToOne
private Producto producto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecioBase() {
        return PrecioBase;
    }

    public void setPrecioBase(int PrecioBase) {
        this.PrecioBase = PrecioBase;
    }

    public Object getStock() {
        return stock;
    }

    public void setStock(Object stock) {
        this.stock = stock;
    }

    public Object getProveedorOpcional() {
        return ProveedorOpcional;
    }

    public void setProveedorOpcional(Object ProveedorOpcional) {
        this.ProveedorOpcional = ProveedorOpcional;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public Object getDescuento() {
        return descuento;
    }

    public void setDescuento(Object descuento) {
        this.descuento = descuento;
    }



    
}
