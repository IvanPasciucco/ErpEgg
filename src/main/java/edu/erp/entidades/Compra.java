package edu.erp.entidades;

import edu.erp.enumeraciones.Estado;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Compra {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @OneToOne
    private Factura factura;
//    
//    @OneToMany
//    private Producto productos;
//    
//    @OneToMany
//    private Pedidos pedidos;
    
    private double PrecioAprox;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaAutomatica;
    
    @Enumerated(EnumType.STRING)
    private Estado estado;
    
    @OneToOne
    private Cliente cliente;
    
    @OneToOne
    private Pago pago;
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public double getPrecioAprox() {
        return PrecioAprox;
    }

    public void setPrecioAprox(double PrecioAprox) {
        this.PrecioAprox = PrecioAprox;
    }

    public Date getFechaAutomatica() {
        return FechaAutomatica;
    }

    public void setFechaAutomatica(Date FechaAutomatica) {
        this.FechaAutomatica = FechaAutomatica;
    }
//
//    public Producto getProductos() {
//        return productos;
//    }
//
//    public void setProductos(Producto productos) {
//        this.productos = productos;
//    }
//
//    public Pedidos getPedidos() {
//        return pedidos;
//    }
//
//    public void setPedidos(Pedidos pedidos) {
//        this.pedidos = pedidos;
//    }
    
}
