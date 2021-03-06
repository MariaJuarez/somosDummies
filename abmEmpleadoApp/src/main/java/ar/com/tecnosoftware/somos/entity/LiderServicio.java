package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LDS", schema = "dbo", catalog = "Somos")
public class LiderServicio {
    private short idLds;
    private String nombre;

    @Id
    @Column(name = "IdLDS")
    public short getIdLds() {
        return idLds;
    }

    public void setIdLds(short idLds) {
        this.idLds = idLds;
    }

    @Basic
    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiderServicio that = (LiderServicio) o;
        return idLds == that.idLds &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLds, nombre);
    }
}
