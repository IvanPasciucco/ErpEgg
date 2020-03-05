package edu.erp.repositorios;

import edu.erp.entidades.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepositorio extends JpaRepository <Empleado, String> {
@Query("Select c From Empleado c")
public List<Empleado> ObtenerEmpleados();
//@Query("Select c From Empleados where c.id = :id")
//public Empleado ObtenerEmpleadoId(@Param("id") String id);

}
