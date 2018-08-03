package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class ProyectoEmpleado {
    private int idProyectoEmpleado;
    private int anioLps;
    private String tareasProyecto;
    private Date fechaRelevamiento;
    private Empleado empleado;
    private Proyecto proyecto;
    private Perfil perfil;
    private List<Tecnologia> tecnologias;

    @Id
    @Column(name = "IdProyectoEmpleado")
    public int getIdProyectoEmpleado() {
        return idProyectoEmpleado;
    }

    public void setIdProyectoEmpleado(int idProyectoEmpleado) {
        this.idProyectoEmpleado = idProyectoEmpleado;
    }

    @Basic
    @Column(name = "AnioLPS")
    public int getAnioLps() {
        return anioLps;
    }

    public void setAnioLps(int anioLps) {
        this.anioLps = anioLps;
    }

    @Basic
    @Column(name = "TareasProyecto")
    public String getTareasProyecto() {
        return tareasProyecto;
    }

    public void setTareasProyecto(String tareasProyecto) {
        this.tareasProyecto = tareasProyecto;
    }

    @Basic
    @Column(name = "FechaRelevamiento")
    public Date getFechaRelevamiento() {
        return fechaRelevamiento;
    }

    public void setFechaRelevamiento(Date fechaRelevamiento) {
        this.fechaRelevamiento = fechaRelevamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyectoEmpleado that = (ProyectoEmpleado) o;
        return idProyectoEmpleado == that.idProyectoEmpleado &&
                anioLps == that.anioLps &&
                Objects.equals(tareasProyecto, that.tareasProyecto) &&
                Objects.equals(fechaRelevamiento, that.fechaRelevamiento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProyectoEmpleado, anioLps, tareasProyecto, fechaRelevamiento);
    }

    @ManyToOne
    @JoinColumn(name = "IdEmpleado", referencedColumnName = "IdEmpleado", nullable = false)
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @ManyToOne
    @JoinColumn(name = "IdProyecto", referencedColumnName = "IdProyecto", nullable = false)
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @ManyToOne
    @JoinColumn(name = "IdPerfil", referencedColumnName = "IdPerfil")
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @ManyToMany(mappedBy = "proyectosEmpleado")
    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }
}
