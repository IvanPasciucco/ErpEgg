package edu.erp.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pago {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private int Efectivo;
    private String cheques;

    @OneToOne
    private Compra compra;

    public Pago() {
    }

    public int getEfectivo() {
        return Efectivo;
    }

    public void setEfectivo(int Efectivo) {
        this.Efectivo = Efectivo;
    }

    public String getCheques() {
        return cheques;
    }

    public void setCheques(String cheques) {
        this.cheques = cheques;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
