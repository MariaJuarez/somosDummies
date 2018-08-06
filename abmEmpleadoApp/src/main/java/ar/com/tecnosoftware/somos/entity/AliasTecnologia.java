package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AliasTecnologia {
    private int idAliasTecnologia;
    private String descTecnologia;
    private int idTipoTecnologia;
    private int idTecnologia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAliasTecnologia")
    public int getIdAliasTecnologia() {
        return idAliasTecnologia;
    }

    public void setIdAliasTecnologia(int idAliasTecnologia) {
        this.idAliasTecnologia = idAliasTecnologia;
    }

    @Basic
    @Column(name = "DescTecnologia")
    public String getDescTecnologia() {
        return descTecnologia;
    }

    public void setDescTecnologia(String descTecnologia) {
        this.descTecnologia = descTecnologia;
    }

    @Basic
    @Column(name = "IdTipoTecnologia")
    public int getIdTipoTecnologia() {
        return idTipoTecnologia;
    }

    public void setIdTipoTecnologia(int idTipoTecnologia) {
        this.idTipoTecnologia = idTipoTecnologia;
    }

    @Basic
    @Column(name = "IdTecnologia")
    public int getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(int idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AliasTecnologia that = (AliasTecnologia) o;
        return idAliasTecnologia == that.idAliasTecnologia &&
                idTipoTecnologia == that.idTipoTecnologia &&
                idTecnologia == that.idTecnologia &&
                Objects.equals(descTecnologia, that.descTecnologia);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idAliasTecnologia, descTecnologia, idTipoTecnologia, idTecnologia);
    }
}
