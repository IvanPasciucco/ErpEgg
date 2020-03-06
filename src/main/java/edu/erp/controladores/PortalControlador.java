package edu.erp.controladores;

import edu.erp.entidades.errores.ErrorServicio;
import edu.erp.servicios.UsuarioServicio;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class PortalControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/index")
    public String index(){
        return "index.html";
    }
    
     @GetMapping("/about")
    public String about(){
        return "about.html";
    }
    @GetMapping("/registro")
   public String registro() {
       return "registro.html";
  }
    @PostMapping("/registrar")
   public String registrar(ModelMap modelo, @RequestParam String nombre, @RequestParam  String email, @RequestParam  String tel, @RequestParam String clave){
        try {
            usuarioServicio.registrar(nombre, email, tel, clave);
        } catch (ErrorServicio ex) {
            return "registro.html";
    //        Logger.getLogger(PortalControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       return "index.html";
      
   }
   
   @GetMapping("/shop-grid")
   public String productos() {
       return "shop-grid.html";
  }
   @GetMapping("/contact")
   public String contacto() {
       return "contact.html";
  }
  @GetMapping("/login")
   public String login() {
       return "login.html";
  }
 
   @GetMapping("/my-account")
   public String mi() {
       return "my-account.html";
  }
   

}

