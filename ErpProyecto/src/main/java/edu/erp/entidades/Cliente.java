package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Cliente extends User {
    
    @Id
    @GeneratedValue (generator="uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;
    private String direccion;
    private CarritoCompra carrito;
    private String cuil_cuit;

    @OneToOne
    private User user;
            
    public Cliente(String tel,  String id,String nombre,String clave,String email,String direccion, CarritoCompra carrito, String cuil_cuit) {
        super(id, nombre, clave, email, tel);
        this.direccion = direccion;
        this.carrito = carrito;
        this.cuil_cuit = cuil_cuit;
    }
    
    public Cliente(){
        super();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CarritoCompra getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoCompra carrito) {
        this.carrito = carrito;
    }

    public String getCuil_cuit() {
        return cuil_cuit;
    }

    public void setCuil_cuit(String cuil_cuit) {
        this.cuil_cuit = cuil_cuit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   
}
