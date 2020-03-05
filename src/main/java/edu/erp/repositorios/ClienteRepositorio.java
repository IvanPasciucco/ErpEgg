package edu.erp.repositorios;

import edu.erp.entidades.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

    @Query ("SELECT c From Cliente c")
    public List <Cliente>BuscarTodosLosClientes();
    
//    @Query("Select c From Clientes c Where c.id= :id")
//    public Cliente BuscarClientePorId(@Param ("id") String id);
    
}
