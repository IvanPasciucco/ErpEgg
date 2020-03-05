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
   @GetMapping("/login")
   public String login() {
       return "login.html";
  }
    @PostMapping("/registrar")
   public String registrar(ModelMap modelo){
       System.out.println();//           modelo.put("error", ex.getMessage());
//           modelo.put("nombre", nombre);
//           modelo.put("apellido", apellido);
//           modelo.put("mail", mail);
//           modelo.put("clave", clave);
//           modelo.put("zona", idZona);
//           modelo.put("grupo_sanguineo", grupo_sanguineo);
//           modelo.put("requisitos", id_requisitos);
       return "index.html";
       }
    
}
