package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
    @Id
    @GeneratedValue (generator="uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String clave;
    private String email;
    private String tel;

    public User(String id, String nombre, String clave, String email, String tel) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.email = email;
        this.tel = tel;
    }

    public User() {
    }    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
}
