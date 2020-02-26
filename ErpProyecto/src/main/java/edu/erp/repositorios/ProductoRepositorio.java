package edu.erp.repositorios;

import edu.erp.entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<String, Producto>{
   
    @Query ("Select c From Productos ")
    public List<Producto> BuscarProductos();
    
    @Query ("Select c From Productos where c.id = :id")
    public Producto BuscarProducoId(@Param ("id") String id);
    
    @Query ("Select c From Productos where c.stock =:stock")
    public Producto BuscarProductoPorStock(@Param("stock") Integer stock);
    
}
