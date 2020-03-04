package edu.erp.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class CarritoCompra {
    
    @Id
    @GeneratedValue (generator="uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;

    private double PrecioAprox;

    public CarritoCompra() {
    }
    
   @OneToMany
   private List<Producto> producto;
    
 

    public double getPrecioAprox() {
        return PrecioAprox;
    }

    public void setPrecioAprox(double PrecioAprox) {
        this.PrecioAprox = PrecioAprox;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
    
    
}
