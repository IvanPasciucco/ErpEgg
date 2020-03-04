 package edu.erp.servicios;

import edu.erp.entidades.Cliente;
import edu.erp.entidades.Compra;
import edu.erp.entidades.Producto;
import edu.erp.entidades.User;
import edu.erp.entidades.errores.ErrorServicio;
import edu.erp.enumeraciones.Estado;
import edu.erp.repositorios.CompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteServicio {
    @Autowired
    public CompraRepositorio compraRepositorio;
    private void agregarProducto(Cliente cliente,Producto prod){
        cliente.getCarrito().getProductos().add(prod);
        cliente.getCarrito().setPrecioAprox(prod.getPrecioBase());
        
    }    
    private void quitarProducto(Cliente cliente,Producto prod){
        cliente.getCarrito().getProductos().remove(prod);
        cliente.getCarrito().setPrecioAprox((cliente.getCarrito().getPrecioAprox())-(prod.getPrecioBase()));
        
    }
    private void EjecutarCompra(Cliente cliente)throws ErrorServicio{
        if (cliente.getCompra().equals(null)){
        Compra compra = new Compra();
        compra.setProductos(cliente.getCarrito().getProductos());
        compra.setPrecioAprox(cliente.getCarrito().getPrecioAprox());
        compra.setEstado(Estado.PENDIENTE);
        compra.setCliente(cliente);
        compraRepositorio.save(compra); 
    }else if(cliente.getCompra().getEstado().equals(Estado.RECHAZADO)){
        throw new ErrorServicio("La compra ha sido rechazada");
    }else if(cliente.getCompra().getEstado().equals(Estado.ACEPTADO)){
        
    }
        }
    
    
}
