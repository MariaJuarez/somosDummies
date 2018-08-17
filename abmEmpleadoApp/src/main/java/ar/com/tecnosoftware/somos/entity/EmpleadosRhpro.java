package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class EmpleadosRhpro implements Serializable {
    private int idEmpleadosRhpro;
    private String cliente;
    private double empleado;
    private String nombreCompleto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEmpleadosRhpro")
    public int getIdEmpleadosRhpro() {
        return idEmpleadosRhpro;
    }

    public void setIdEmpleadosRhpro(int idEmpleadosRhpro) {
        this.idEmpleadosRhpro = idEmpleadosRhpro;
    }

    @Basic
    @Column(name = "Cliente")
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Basic
    @Column(name = "Empleado")
    public double getEmpleado() {
        return empleado;
    }

    public void setEmpleado(double empleado) {
        this.empleado = empleado;
    }

    @Basic
    @Column(name = "nombre_completo")
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadosRhpro that = (EmpleadosRhpro) o;
        return Double.compare(that.empleado, empleado) == 0 &&
                Objects.equals(cliente, that.cliente) &&
                Objects.equals(nombreCompleto, that.nombreCompleto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cliente, empleado, nombreCompleto);
    }
}
