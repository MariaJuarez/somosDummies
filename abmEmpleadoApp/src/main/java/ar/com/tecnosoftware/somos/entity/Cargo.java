package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cargo implements Serializable {
    private int idCargoRhpro;
    private String descCargoRhpro;
    private boolean baja;
    private Empleado empleado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCargorhpro")
    public int getIdCargoRhpro() {
        return idCargoRhpro;
    }

    public void setIdCargoRhpro(int idCargoRhpro) {
        this.idCargoRhpro = idCargoRhpro;
    }

    @Basic
    @Column(name = "DescCargoRHPRO")
    public String getDescCargoRhpro() {
        return descCargoRhpro;
    }

    public void setDescCargoRhpro(String descCargoRhpro) {
        this.descCargoRhpro = descCargoRhpro;
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
        Cargo that = (Cargo) o;
        return idCargoRhpro == that.idCargoRhpro &&
                Objects.equals(descCargoRhpro, that.descCargoRhpro);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCargoRhpro, descCargoRhpro);
    }

    @Transient
    @OneToOne(mappedBy = "cargo")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
