package edu.erp.controladores;

import edu.erp.entidades.errores.ErrorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PortalControlador {
    
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
   @GetMapping("/crear-cuenta")
   public String crear() {
       return "crear-cuenta.html";
  }
   @GetMapping("/my-account")
   public String mi() {
       return "my-account.html";
  }
    @PostMapping("/registrar")
   public String registrar(ModelMap modelo){
       System.out.println();//           modelo.put("error", ex.getMessage());
//           modelo.put("nombre", nombre);
//           modelo.put("apellido", apellido);
//           modelo.put("mail", mail);
//           modelo.put("clave", clave);
       return "index.html";
       }
    
}
