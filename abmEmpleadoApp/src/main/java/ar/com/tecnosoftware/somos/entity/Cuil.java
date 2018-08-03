package ar.com.tecnosoftware.somos.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Cuil {
    private double legajo;
    private String nombre;
    private String cuil;

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

    @Basic
    @Column(name = "CUIL")
    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuil cuil1 = (Cuil) o;
        return Double.compare(cuil1.legajo, legajo) == 0 &&
                Objects.equals(nombre, cuil1.nombre) &&
                Objects.equals(cuil, cuil1.cuil);
    }

    @Override
    public int hashCode() {

        return Objects.hash(legajo, nombre, cuil);
    }
}
