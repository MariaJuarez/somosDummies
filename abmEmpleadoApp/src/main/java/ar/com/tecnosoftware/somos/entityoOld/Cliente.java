package ar.com.tecnosoftware.somos.entityoOld;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {

    /**
     * Entidad de la DB relacionada a la tabla cliente
     */

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @NotBlank
    @Column(name="baja")
    private boolean baja;

    public Cliente(){}

    public Cliente(int id, String descripcion, boolean baja) {
        this.id = id;
        this.descripcion = descripcion;
        this.baja = baja;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
