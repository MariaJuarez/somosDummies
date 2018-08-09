package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class TipoProyecto implements Serializable {
    private int idTipoProyecto;
    private String descTipoProyecto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoProyecto")
    public int getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(int idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    @Basic
    @Column(name = "DescTipoProyecto")
    public String getDescTipoProyecto() {
        return descTipoProyecto;
    }

    public void setDescTipoProyecto(String descTipoProyecto) {
        this.descTipoProyecto = descTipoProyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoProyecto that = (TipoProyecto) o;
        return idTipoProyecto == that.idTipoProyecto &&
                Objects.equals(descTipoProyecto, that.descTipoProyecto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTipoProyecto, descTipoProyecto);
    }
}
