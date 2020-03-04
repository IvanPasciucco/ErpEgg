package edu.erp.servicios;

import edu.erp.entidades.Foto;
import edu.erp.entidades.Producto;
import edu.erp.entidades.User;
import edu.erp.entidades.errores.ErrorServicio;
import edu.erp.repositorios.CompraRepositorio;
import edu.erp.repositorios.FotoRepositorio;
import edu.erp.repositorios.UserRepositorio;
import java.util.Date;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UsuarioServicio {
    
    @Autowired
    private UserRepositorio usuarioRepositorio;
    @Autowired
    private CompraRepositorio compraRepositorio;
    @Autowired
    private FotoServicio fotoServicio;

    
    private void Registrar(MultipartFile archivo,String id,String nombre, String apellido, String mail, String clave, String clave2) throws ErrorServicio{
        
        validar(id,nombre,apellido,mail,clave,clave2);
        User usuario = new User();
        usuario.setNombre(nombre);
        usuario.setId(id);
        usuario.setEmail(mail);
        usuario.setAlta(new Date());
        
        Foto foto = fotoServicio.guardar(archivo);
        usuario.setFoto(foto);
        
        usuarioRepositorio.save(usuario);
        
        
    }
    private void modificar (MultipartFile foto, String DNI, String nombre,String apellido,String mail,String clave,String clave2) throws ErrorServicio{
        validar(DNI,nombre,apellido,mail,clave,clave2);
        

        User res = usuarioRepositorio.ObtenerUsuarioporId(DNI);
        if (res!=null){
        User user = res;
        String id= null;
        if(user.getFoto()!=null){
          id = user.getFoto().getId();
        }
        user.setNombre(nombre);
        user.setId(DNI);
        user.setEmail(mail);
        
        Foto fotoNew = fotoServicio.actualizar(id,foto);
        user.setFoto(fotoNew);
        usuarioRepositorio.save(user);
    }else{
            throw new ErrorServicio("No se encontro el usuario a modificar");
        }
    
    }
        @Transactional
    public void deshabilitar(String id) throws ErrorServicio{
        Optional<User> respuesta = usuarioRepositorio.findById(id);
        if(respuesta.isPresent()){
            User usuario = respuesta.get();
            usuario.setBaja(new Date());
            usuarioRepositorio.save(usuario);
        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado.");
        }
    }

    @Transactional
    public void habilitar(String id) throws ErrorServicio{
        Optional<User> respuesta = usuarioRepositorio.findById(id);
        if(respuesta.isPresent()){
            User usuario = respuesta.get();
            usuario.setBaja(null);
            usuarioRepositorio.save(usuario);
        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado.");
        }
    }

    private void validar(String id,String nombre, String apellido, String mail, String clave, String clave2) throws ErrorServicio{
        if (id ==null || id.isEmpty() || !usuarioRepositorio.ObtenerUsuarioporId(id).getNombre().equals(null)){
            throw new ErrorServicio("El DNI es invalido o ya esta utilizado");
        }
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre del usuario no puede ser nulo.");
        }

        if(apellido == null || apellido.isEmpty()){
            throw new ErrorServicio("El apellido del usuario no puede ser nulo.");
        }
        
        if(mail == null || mail.isEmpty()){
            throw new ErrorServicio("El mail del usuario no puede ser nulo.");
        }
        
        if(clave == null || clave.isEmpty() || clave.length() <= 6){
            throw new ErrorServicio("La clave del usuario no puede ser nula y tiene que tener mas de seis dígitos.");
        }
        
        if(!clave.equals(clave2)){
            throw new ErrorServicio(("Las claves deben ser iguales."));
        }
    }
}
