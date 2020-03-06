package edu.erp.repositorios;

import edu.erp.entidades.Administrador;
import edu.erp.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepositorio extends JpaRepository<Administrador, String> {
//
    @Query("Select a From Administrador a")
    public Administrador BuscarAdmin();
//    @Query("Select c From Administrador c where c.DNI = :DNI")
//    public Usuario ObtenerUsuarioporId(@Param("DNI") String DNI);
        @Query("SELECT c FROM Administrador c WHERE c.email = :email")
    public Administrador buscarPorEmail(@Param("email") String email);
    
}
