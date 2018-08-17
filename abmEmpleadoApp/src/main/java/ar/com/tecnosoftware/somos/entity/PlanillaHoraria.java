package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class PlanillaHoraria implements Serializable {
    private int idPlanillaHoraria;
    private String empleado;
    private int credencial;
    private Date fecha;
    private String tipo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPlanillaHoraria")
    public int getIdPlanillaHoraria() {
        return idPlanillaHoraria;
    }

    public void setIdPlanillaHoraria(int idPlanillaHoraria) {
        this.idPlanillaHoraria = idPlanillaHoraria;
    }

    @Basic
    @Column(name = "Empleado")
    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    @Basic
    @Column(name = "Credencial")
    public int getCredencial() {
        return credencial;
    }

    public void setCredencial(int credencial) {
        this.credencial = credencial;
    }

    @Basic
    @Column(name = "Fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "Tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanillaHoraria that = (PlanillaHoraria) o;
        return credencial == that.credencial &&
                Objects.equals(empleado, that.empleado) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(empleado, credencial, fecha, tipo);
    }
}
