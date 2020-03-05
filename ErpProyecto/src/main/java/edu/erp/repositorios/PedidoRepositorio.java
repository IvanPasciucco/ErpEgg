package edu.erp.repositorios;

import edu.erp.entidades.Pedidos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository <Pedidos,String> {

    
@Query("Select c from pedidos c where c.estado =:estado")
public List<Pedidos> BuscarPedidosPorEstado(@Param("estado") String estado);
}
