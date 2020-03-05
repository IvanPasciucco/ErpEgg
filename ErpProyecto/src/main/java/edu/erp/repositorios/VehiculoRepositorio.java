package edu.erp.repositorios;

import edu.erp.entidades.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepositorio extends JpaRepository <Vehiculo,String> {

@Query("Select c from pedidos c where c.empleado.id =:ide")
public Vehiculo buscarPedidosPorIDempleado(@Param("ide") String estado);
@Query("Select c from vehiculos c where c.id =:id")
public Vehiculo buscarVehiculosID(@Param ("id") String id);
@Query("Select c from vehiculos c where c.Capacidad=:capa")
public Vehiculo buscarporCapacidad(@Param("capa") int capa);
}