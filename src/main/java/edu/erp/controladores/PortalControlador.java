package edu.erp.controladores;

import edu.erp.entidades.errores.ErrorServicio;
import edu.erp.servicios.UsuarioServicio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
    @PostMapping("/registrar")
   public String registrar(ModelMap modelo, String nombre, String email, String tel, String clave, Date alta){
       try {
    	   System.out.println(nombre+ email+ tel+ clave);
       usuarioServicio.registrar(nombre, clave, email, tel, alta);
       } catch (ErrorServicio ex) {
           modelo.put("nombre", nombre);

     modelo.put("mail", email);
     modelo.put("tel", tel);
  modelo.put("clave", clave);
       return "index.html";
       }
   /* @PostMapping("/registrar")
//   public String registrar(ModelMap modelo, String nombre, String apellido, String mail, String clave, String grupo_sanguineo,
   		String zona, String edad, String peso,
   		String medicacion, String alergias, String antecedentes){
       try {
    	   System.out.println(nombre+  apellido+  mail+  clave+  grupo_sanguineo+
           		 zona+  Integer.parseInt(edad)+  Integer.parseInt(peso)+  
        		 medicacion+  alergias+  antecedentes);
           usuarioServicio.registrar( nombre,  apellido,  mail,  clave,  grupo_sanguineo,
           		 zona,  Integer.parseInt(edad),  Integer.parseInt(peso), 
        		 medicacion,  alergias,  antecedentes);
       } catch (ErrorServicio ex) {
          
//           modelo.put("error", ex.getMessage());
//           modelo.put("nombre", nombre);
//           modelo.put("apellido", apellido);
//           modelo.put("mail", mail);
//           modelo.put("clave", clave);
//           modelo.put("zona", idZona);
//           modelo.put("grupo_sanguineo", grupo_sanguineo);
//           modelo.put("requisitos", id_requisitos);
          return "registro.html";
           
       }
       return "index.html";
       }
}*/
        return null;
}
}
