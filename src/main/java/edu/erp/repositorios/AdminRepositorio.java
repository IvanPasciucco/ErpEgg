package edu.erp.repositorios;

import edu.erp.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepositorio extends JpaRepository<Administrador, String> {

}
