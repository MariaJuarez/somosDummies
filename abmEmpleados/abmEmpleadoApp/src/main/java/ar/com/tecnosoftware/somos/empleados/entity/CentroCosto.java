package ar.com.tecnosoftware.somos.empleados.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CentroCosto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "decripcion")
    private String descripcion;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
