package edu.erp.repositorios;

import edu.erp.entidades.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,String >{
//    @Query ("Select c From Productos c where c.id = :id")
//    public Producto BuscarProducoId(@Param ("id") String id);
    
//    @Query ("Select c From Productos c where c.stock =:stock")
//    public Producto BuscarProductoPorStock(@Param("stock") Integer stock);

//    @Query ("Select c From Productos c where c.Nombre =:Nombre")
//    public Producto BuscarProductoPorNombre(@Param("Nombre") String Nombre);
//    
}
