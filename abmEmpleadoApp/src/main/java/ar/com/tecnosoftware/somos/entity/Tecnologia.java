package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Tecnologia {
    private int idTecnologia;
    private String descTecnologia;
    private TipoTecnologia tipoTecnologia;
    private List<ProyectoEmpleado> proyectosEmpleado;

    @Id
    @Column(name = "IdTecnologia")
    public int getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(int idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    @Basic
    @Column(name = "DescTecnologia")
    public String getDescTecnologia() {
        return descTecnologia;
    }

    public void setDescTecnologia(String descTecnologia) {
        this.descTecnologia = descTecnologia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tecnologia that = (Tecnologia) o;
        return idTecnologia == that.idTecnologia &&
                Objects.equals(descTecnologia, that.descTecnologia);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTecnologia, descTecnologia);
    }

    @ManyToOne
    @JoinColumn(name = "IdTipoTecnologia", referencedColumnName = "IdTipoTecnologia", nullable = false)
    public TipoTecnologia getTipoTecnologia() {
        return tipoTecnologia;
    }

    public void setTipoTecnologia(TipoTecnologia tipoTecnologia) {
        this.tipoTecnologia = tipoTecnologia;
    }

    @ManyToMany
    @JoinTable(name = "ProyectoTecnologiaEmpleado", catalog = "Somos", schema = "dbo", joinColumns = @JoinColumn(name = "IdTecnologia", referencedColumnName = "IdTecnologia", nullable = false), inverseJoinColumns = @JoinColumn(name = "IdProyectoEmpleado", referencedColumnName = "IdProyectoEmpleado", nullable = false))
    public List<ProyectoEmpleado> getProyectosEmpleado() {
        return proyectosEmpleado;
    }

    public void setProyectosEmpleado(List<ProyectoEmpleado> proyectosEmpleado) {
        this.proyectosEmpleado = proyectosEmpleado;
    }
}
