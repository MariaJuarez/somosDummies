package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Perfil implements Serializable {
    private int idPerfil;
    private String abrvPerfil;
    private String descPerfil;
    private List<ProyectoEmpleado> proyectosEmpleado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPerfil")
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Basic
    @Column(name = "AbrvPerfil")
    public String getAbrvPerfil() {
        return abrvPerfil;
    }

    public void setAbrvPerfil(String abrvPerfil) {
        this.abrvPerfil = abrvPerfil;
    }

    @Basic
    @Column(name = "DescPerfil")
    public String getDescPerfil() {
        return descPerfil;
    }

    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return idPerfil == perfil.idPerfil &&
                Objects.equals(abrvPerfil, perfil.abrvPerfil) &&
                Objects.equals(descPerfil, perfil.descPerfil);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPerfil, abrvPerfil, descPerfil);
    }

    @Transient
    @OneToMany(mappedBy = "perfil")
    public List<ProyectoEmpleado> getProyectosEmpleado() {
        return proyectosEmpleado;
    }

    public void setProyectosEmpleado(List<ProyectoEmpleado> proyectosEmpleado) {
        this.proyectosEmpleado = proyectosEmpleado;
    }
}
