package ar.com.tecnosoftware.somos.empleados.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad de la DB relacionada a la tabla centro_costo
 */
@Entity
public class CentroCosto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "decripcion")
    private String descripcion;

    @NotBlank
    @Column(name="baja")
    private boolean baja;

    public CentroCosto(){}

    public CentroCosto(int id, String descripcion, boolean baja) {
        this.id = id;
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
