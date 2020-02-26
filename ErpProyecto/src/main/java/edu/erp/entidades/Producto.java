package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Producto {

@Id
@GeneratedValue (generator="uuid")
@GenericGenerator(name= "uuid", strategy = "uuid2")
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
