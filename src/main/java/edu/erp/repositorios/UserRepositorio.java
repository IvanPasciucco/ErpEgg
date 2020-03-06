package edu.erp.repositorios;

import edu.erp.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorio extends JpaRepository<Usuario, String> {

    @Query("Select c From Usuario c where c.email = :id")
    public Usuario ObtenerUsuarioporId(@Param("id") String id);
}
