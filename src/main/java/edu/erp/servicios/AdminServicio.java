/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AdminServicio implements UserDetailsService{
    
    @Autowired
    private AdminRepositorio adminRepositorio;
    

    
    
    @Transactional
    public void registrar(String id, String nombre, String clave, String email, String tel)throws ErrorServicio{
        
//        Zona zona = zonaRepositorio.getOne(idZona);
//        Requisitos requisitos = requisitosRepositorio.getOne(id_requisitos);
//        
        //validar(nombre, apellido, mail, clave, zona, grupo_sanguineo, requisitos);
        
        Administrador administrador= new Administrador();
       
        administrador.setNombre(nombre);
      
        administrador.setEmail(email);
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        administrador.setClave(encriptada);
       administrador.setTel(tel);
       // usuario.setUltima_donacion(ultima_donacion);
       // usuario.setUltimo_piercing(ultimo_piercing);
       // usuario.setUltimo_tatuaje(ultimo_tatuaje);
       
        
  
        
        administrador.setAlta(new Date());
        
       adminRepositorio.save(administrador);
        
    }
    
    
//    public void modificar (String id, String nombre, String apellido, String mail, String clave, String clave2, String idZona, String grupo_sanguineo,String id_requisitos) throws ErrorServicio{
    
        // Zona zona = zonaRepositorio.getOne(idZona);
       //  Requisitos requisitos = requisitosRepositorio.getOne(id_requisitos);


//        validar(nombre, apellido, mail, clave,zona,grupo_sanguineo,requisitos);
//        
//        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
//        if(respuesta.isPresent()){
//            Usuario usuario = respuesta.get();
//           
//            usuario.setNombre(nombre);
//            usuario.setApellido(apellido);
//            usuario.setMail(mail);
//            usuario.setZona(zona);
//            usuario.setGrupo_sanguineo(grupo_sanguineo);
//            usuario.setRequisitos(requisitos);
//            
//     
//            String encriptada = new BCryptPasswordEncoder().encode(clave);
//            usuario.setClave(encriptada);
//            
//           
//            
//
//            usuarioRepositorio.save(usuario);
//        } else {
//            throw new ErrorServicio("No se encontró el usuario solicitado.");
//        }
//    }
    
    @Transactional
    public void deshabilitar(String id) throws ErrorServicio{
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if(respuesta.isPresent()){
            Usuario usuario = respuesta.get();
            usuario.setBaja(new Date());
            usuarioRepositorio.save(usuario);
        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado.");
        }
    }

    @Transactional
    public void habilitar(String id) throws ErrorServicio{
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if(respuesta.isPresent()){
            Usuario usuario = respuesta.get();
            usuario.setBaja(null);
            usuarioRepositorio.save(usuario);
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
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.buscarPorMail(mail);
        if(usuario != null){
            
            List<GrantedAuthority> permisos = new ArrayList<>();
            
            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_USUARIO_REGISTRADO");
            permisos.add(p1);
            
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true); 
            session.setAttribute("usuariosession", usuario);

            User user = new User(usuario.getMail(), usuario.getClave(), permisos);
            return user;
        } else {
            return null;
        }
    }

    
    
}


        
        
    
    
        
        
    
        
        
        
        
        
        
        
        
        
    
            
    
    
    
    

