package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Usuario {
    private int idUsuario;
    private String descUsuario;
    private boolean baja;
    private Empleado empleado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "DescUsuario")
    public String getDescUsuario() {
        return descUsuario;
    }

    public void setDescUsuario(String descUsuario) {
        this.descUsuario = descUsuario;
    }

    @Basic
    @Column(name = "Baja")
    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario &&
                Objects.equals(descUsuario, usuario.descUsuario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUsuario, descUsuario);
    }

    @OneToOne(mappedBy = "usuario")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
