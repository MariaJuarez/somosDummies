package ar.com.tecnosoftware.somos.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class EmpleadosRhpro {
    private String cliente;
    private double empleado;
    private String apellidoYNombre;

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
    @Column(name = "Apellido y Nombre")
    public String getApellidoYNombre() {
        return apellidoYNombre;
    }

    public void setApellidoYNombre(String apellidoYNombre) {
        this.apellidoYNombre = apellidoYNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadosRhpro that = (EmpleadosRhpro) o;
        return Double.compare(that.empleado, empleado) == 0 &&
                Objects.equals(cliente, that.cliente) &&
                Objects.equals(apellidoYNombre, that.apellidoYNombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cliente, empleado, apellidoYNombre);
    }
}
