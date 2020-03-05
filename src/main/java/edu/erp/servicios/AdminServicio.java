
package edu.erp.servicios;

import edu.erp.entidades.Administrador;
import edu.erp.entidades.errores.ErrorServicio;
import edu.erp.repositorios.AdminRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author ivan
 */
@Service
public class AdminServicio implements UserDetailsService {

    @Autowired
    private AdminRepositorio adminRepositorio;

    @Transactional
    public void registrar(String id, String nombre, String clave, String email, String tel) throws ErrorServicio {

        Administrador administrador = new Administrador();

        administrador.setNombre(nombre);

        administrador.setEmail(email);
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        administrador.setClave(encriptada);
        administrador.setTel(tel);


        administrador.setAlta(new Date());

        adminRepositorio.save(administrador);

    }

    public void modificar(String DNI, String nombre, String clave, String email, String tel) throws ErrorServicio {

        Optional<Administrador> respuesta = adminRepositorio.findById(DNI);
        if (respuesta.isPresent()) {
            Administrador administrador = respuesta.get();

            administrador.setNombre(nombre);
            String encriptada = new BCryptPasswordEncoder().encode(clave);

            administrador.setClave(encriptada);

            adminRepositorio.save(administrador);
        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado.");
        }
    }

    @Transactional
    public void deshabilitar(String DNI) throws ErrorServicio {
        Optional<Administrador> respuesta = adminRepositorio.findById(DNI);
        if (respuesta.isPresent()) {
            Administrador administrador = respuesta.get();
            administrador.setBaja(new Date());
            adminRepositorio.save(administrador);
        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado.");
        }
    }

    @Transactional
    public void habilitar(String DNI) throws ErrorServicio {
        Optional<Administrador> respuesta = adminRepositorio.findById(DNI);
        if (respuesta.isPresent()) {
            Administrador administrador = respuesta.get();

            administrador.setBaja(null);
            adminRepositorio.save(administrador);
        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Administrador administrador = adminRepositorio.buscarPorEmail(email);
        if (administrador != null) {

            List<GrantedAuthority> permisos = new ArrayList<>();

            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_ADMIN_REGISTRADO");
            permisos.add(p1);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", administrador);

            User user = new User(administrador.getEmail(), administrador.getClave(), permisos);
            return user;
        } else {
            return null;
        }
    }

}
