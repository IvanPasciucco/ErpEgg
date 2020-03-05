package edu.erp.repositorios;

import edu.erp.entidades.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorio extends JpaRepository<User, String> {

    @Query("Select c From User c where c.DNI = :id")
    public User ObtenerUsuarioporId(@Param("id") String id);
}
