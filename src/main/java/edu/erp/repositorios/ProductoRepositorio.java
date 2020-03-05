package edu.erp.repositorios;

import edu.erp.entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String>{
//   
    @Query ("Select c From Producto c")
    public List<Producto> BuscarProductos();
//    
//    @Query ("Select c From Productos where c.id = :id")
//    public Producto BuscarProducoId(@Param ("id") String id);
    
    @Query ("SELECT c FROM Producto c WHERE c.stock =:stock")
    public Producto BuscarProductoPorStock(@Param("stock") int stock);
//    
}
