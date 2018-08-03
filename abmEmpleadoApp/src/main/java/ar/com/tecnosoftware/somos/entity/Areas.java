package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Areas {
    private int idCargoRhpro;
    private String descCargoRhpro;
    private Empleado empleado;

    @Id
    @Column(name = "IdCargoRHPRO")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Areas that = (Areas) o;
        return idCargoRhpro == that.idCargoRhpro &&
                Objects.equals(descCargoRhpro, that.descCargoRhpro);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCargoRhpro, descCargoRhpro);
    }

    @OneToOne(mappedBy = "cargo")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
