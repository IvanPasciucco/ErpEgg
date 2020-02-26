package edu.erp.repositorios;

import edu.erp.entidades.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorio extends JpaRepository<String, User> {
    @Query("Select c From User")
    public List<User> ObtenerUsuarios();
    @Query("Select c From User where c.id = :id")
    public User ObtenerUsuarioporId(@Param("id") String id);
}
