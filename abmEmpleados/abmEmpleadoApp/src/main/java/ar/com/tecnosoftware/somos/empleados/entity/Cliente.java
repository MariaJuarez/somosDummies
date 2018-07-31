package ar.com.tecnosoftware.somos.empleados.entity;

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

    public Cliente(){}

    public Cliente(int id, String descripcion) {
        this.id = id;
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
