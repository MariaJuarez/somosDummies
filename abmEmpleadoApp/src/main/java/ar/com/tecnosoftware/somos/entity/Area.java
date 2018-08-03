package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CentroCosto", schema = "dbo", catalog = "Somos")
public class Area {
    private int idCentroCosto;
    private String descCentroCosto;
    private Empleado empleado;

    @Id
    @Column(name = "IdCentroCosto")
    public int getIdCentroCosto() {
        return idCentroCosto;
    }

    public void setIdCentroCosto(int idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }

    @Basic
    @Column(name = "DescCentroCosto")
    public String getDescCentroCosto() {
        return descCentroCosto;
    }

    public void setDescCentroCosto(String descCentroCosto) {
        this.descCentroCosto = descCentroCosto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return idCentroCosto == area.idCentroCosto &&
                Objects.equals(descCentroCosto, area.descCentroCosto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCentroCosto, descCentroCosto);
    }

    @OneToOne(mappedBy = "area")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
