package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {
    private int idCliente;
    private String descCliente;
    private int idLds;
    private String descClienteLps;
    private String grupo;
    private List<Empleado> empleadosCliente;
    private Rubro rubro;
    private Proyecto proyecto;

    @Id
    @Column(name = "IdCliente")
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "DescCliente")
    public String getDescCliente() {
        return descCliente;
    }

    public void setDescCliente(String descCliente) {
        this.descCliente = descCliente;
    }

    @Basic
    @Column(name = "IdLDS")
    public int getIdLds() {
        return idLds;
    }

    public void setIdLds(int idLds) {
        this.idLds = idLds;
    }

    @Basic
    @Column(name = "DescClienteLPS")
    public String getDescClienteLps() {
        return descClienteLps;
    }

    public void setDescClienteLps(String descClienteLps) {
        this.descClienteLps = descClienteLps;
    }

    @Basic
    @Column(name = "Grupo")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idCliente == cliente.idCliente &&
                idLds == cliente.idLds &&
                Objects.equals(descCliente, cliente.descCliente) &&
                Objects.equals(descClienteLps, cliente.descClienteLps) &&
                Objects.equals(grupo, cliente.grupo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCliente, descCliente, idLds, descClienteLps, grupo);
    }

    @OneToMany(mappedBy = "clienteEmpleado")
    public List<Empleado> getEmpleadosCliente() {
        return empleadosCliente;
    }

    public void setEmpleadosCliente(List<Empleado> empleadosCliente) {
        this.empleadosCliente = empleadosCliente;
    }

    @OneToOne
    @JoinColumn(name = "IdRubro", referencedColumnName = "IdRubro")
    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    @OneToOne(mappedBy = "cliente")
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
