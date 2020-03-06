package edu.erp.servicios;
import edu.erp.entidades.Administrador;
import edu.erp.entidades.Usuario;
import edu.erp.entidades.errores.ErrorServicio;
import edu.erp.servicios.*;
import edu.erp.repositorios.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioServicio implements UserDetailsService{
    
    @Autowired
private  UserRepositorio userRepositorio;
  

    
    
    @Transactional
    public void registrar(String nombre, String clave, String email, String tel,Date alta)throws ErrorServicio{
        
        
        Usuario user= new Usuario();
       
        user.setNombre(nombre);
        user.setEmail(email);
        user.setTel(tel);
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        user.setClave(encriptada);
       
   
     user.setAlta(new Date());
        userRepositorio.save(user);
    }
    
  @Transactional  
 public void modificar(String DNI, String nombre, String clave, String email, String tel) throws ErrorServicio {

        Optional<Usuario> respuesta = userRepositorio.findById(DNI);
        if (respuesta.isPresent()) {
           Usuario user = respuesta.get();

            user.setNombre(nombre);
            String encriptada = new BCryptPasswordEncoder().encode(clave);

            user.setClave(encriptada);

        userRepositorio.save(user);
        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado.");
        }
    }
    
    @Transactional
    public void deshabilitar(String DNI) throws ErrorServicio{
        Optional<Usuario> respuesta = userRepositorio.findById(DNI);
        if(respuesta.isPresent()){
            Usuario user = respuesta.get();
            user.setBaja(new Date());
        userRepositorio.save(user);
        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado.");
        }
    }

    @Transactional
    public void habilitar(String DNI) throws ErrorServicio{
        Optional<Usuario> respuesta = userRepositorio.findById(DNI);
        if(respuesta.isPresent()){
           Usuario user = respuesta.get();
            user.setBaja(null);
            userRepositorio.save(user);
        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado.");
        }
    }

//    private void validar(String nombre, String apellido, String mail, String clave , Zona zona, String grupo_sanguineo, Requisitos requisitos) throws ErrorServicio{
//        
//        if(nombre == null || nombre.isEmpty()){
//            throw new ErrorServicio("El nombre del usuario no puede ser nulo.");
//        }
//
//        if(apellido == null || apellido.isEmpty()){
//            throw new ErrorServicio("El apellido del usuario no puede ser nulo.");
//        }
//        
//        if(mail == null || mail.isEmpty()){
//            throw new ErrorServicio("El mail del usuario no puede ser nulo.");
//        }
//        
//        if(clave == null || clave.isEmpty() || clave.length() <= 6){
//            throw new ErrorServicio("La clave del usuario no puede ser nula y tiene que tener mas de seis dígitos.");
//        }
//        
//       
//        
//        if(zona == null){
//            throw new ErrorServicio("No se encontró la zona solicitada.");
//        }
//        
//        if(grupo_sanguineo == null){
//            throw new ErrorServicio("El grupo sanguineo no puede ser nulo.");
//        }
//        if(requisitos == null){
//            throw new ErrorServicio("El grupo sanguineo no puede ser nulo.");
//        }
//    }
       
     @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = userRepositorio.ObtenerUsuarioporId(email);
        if(user != null){
            
            List<GrantedAuthority> permisos = new ArrayList<>();
            
            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_USUARIO_REGISTRADO");
            permisos.add(p1);
            
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true); 
            session.setAttribute("usuariosession", user);

            User user1 = new User(user.getEmail(), user.getClave(), permisos);
            return user1;
        } else {
            return null;
        }
    }

    
    
}