package edu.erp.entidades;

import javax.persistence.Entity;
;

@Entity
public class CarritoCompra {

    private Object cliente;
    private Object producto;
    private Object PrecioAprox;

    public Object getCliente() {
        return cliente;
    }

    public void setCliente(Object cliente) {
        this.cliente = cliente;
    }

    public Object getProducto() {
        return producto;
    }

    public void setProducto(Object producto) {
        this.producto = producto;
    }

    public Object getPrecioAprox() {
        return PrecioAprox;
    }

    public void setPrecioAprox(Object PrecioAprox) {
        this.PrecioAprox = PrecioAprox;
    }

}
