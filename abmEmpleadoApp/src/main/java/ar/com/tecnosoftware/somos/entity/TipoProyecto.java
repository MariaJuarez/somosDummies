package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class TipoProyecto {
    private int idTipoProyecto;
    private String descTipoProyecto;
    private Proyecto proyecto;

    @Id
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

    @OneToOne(mappedBy = "tipoProyecto")
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
