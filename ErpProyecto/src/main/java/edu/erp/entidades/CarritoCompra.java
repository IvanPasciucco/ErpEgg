package edu.erp.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class CarritoCompra {
    
    @Id
    @GeneratedValue (generator="uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;
    private List<Producto> productos;
    private Object PrecioAprox;

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Object getPrecioAprox() {
        return PrecioAprox;
    }

    public void setPrecioAprox(Object PrecioAprox) {
        this.PrecioAprox = PrecioAprox;
    }

}
