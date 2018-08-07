package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cuil {
    private int idCuil;
    private double legajo;
    private String nombre;
    private String cuil;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCuil")
    public int getIdCuil() {
        return idCuil;
    }

    public void setIdCuil(int idCuil) {
        this.idCuil = idCuil;
    }

    @Basic
    @Column(name = "legajo")
    public double getLegajo() {
        return legajo;
    }

    public void setLegajo(double legajo) {
        this.legajo = legajo;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name = "cuil")
    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cuil)) return false;
        Cuil cuil1 = (Cuil) o;
        return idCuil == cuil1.idCuil &&
                Double.compare(cuil1.legajo, legajo) == 0 &&
                Objects.equals(nombre, cuil1.nombre) &&
                Objects.equals(cuil, cuil1.cuil);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCuil, legajo, nombre, cuil);
    }

    public Cuil() {
    }
}
