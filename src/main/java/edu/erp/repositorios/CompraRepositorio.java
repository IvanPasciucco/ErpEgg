package edu.erp.repositorios;

import edu.erp.entidades.Compra;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepositorio extends JpaRepository<Compra, String> {

//    @Query("Select c from Compras where c.id =:id")
//    public Compra ObtenerCompraPorId(@Param("id") String id); 
    @Query("Select c from Compra c where c.id =:id")
    public List<Compra> ObtenerCompras(); 
}
