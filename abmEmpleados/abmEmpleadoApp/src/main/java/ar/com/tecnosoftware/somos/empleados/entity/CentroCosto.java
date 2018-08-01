package ar.com.tecnosoftware.somos.empleados.entity;

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

    public CentroCosto(){}

    public CentroCosto(String descripcion) {
        this.descripcion = descripcion;
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
