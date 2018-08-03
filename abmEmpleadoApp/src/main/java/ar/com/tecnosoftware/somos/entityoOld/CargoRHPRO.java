package ar.com.tecnosoftware.somos.entityoOld;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad de la DB relacionada a la tabla CargoRHPRO
 */

@Entity
public class CargoRHPRO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name="baja")
    private boolean baja;

    public CargoRHPRO(){}

    public CargoRHPRO(String descripcion, boolean baja) {
        this.descripcion = descripcion;
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

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }
}
