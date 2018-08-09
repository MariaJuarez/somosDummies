package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class TipoTecnologia implements Serializable {
    private int idTipoTecnologia;
    private String descTipoTecnologia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoTecnologia")
    public int getIdTipoTecnologia() {
        return idTipoTecnologia;
    }

    public void setIdTipoTecnologia(int idTipoTecnologia) {
        this.idTipoTecnologia = idTipoTecnologia;
    }

    @Basic
    @Column(name = "DescTipoTecnologia")
    public String getDescTipoTecnologia() {
        return descTipoTecnologia;
    }

    public void setDescTipoTecnologia(String descTipoTecnologia) {
        this.descTipoTecnologia = descTipoTecnologia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTecnologia that = (TipoTecnologia) o;
        return idTipoTecnologia == that.idTipoTecnologia &&
                Objects.equals(descTipoTecnologia, that.descTipoTecnologia);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTipoTecnologia, descTipoTecnologia);
    }

}
