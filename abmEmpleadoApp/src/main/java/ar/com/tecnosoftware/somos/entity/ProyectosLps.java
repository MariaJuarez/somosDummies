package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class ProyectosLps {
    private int idProyectoLps;
    private int idcliente;
    private String nombreProyecto;
    private String descProyecto;
    private String herramientas;
    private String tipo;
    private Date fechaInicio;
    private Date fechaFin;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProyectoLPS")
    public int getIdProyectoLps() {
        return idProyectoLps;
    }

    public void setIdProyectoLps(int idProyectoLps) {
        this.idProyectoLps = idProyectoLps;
    }

    @Basic
    @Column(name = "idcliente")
    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    @Basic
    @Column(name = "nombreProyecto")
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    @Basic
    @Column(name = "descProyecto")
    public String getDescProyecto() {
        return descProyecto;
    }

    public void setDescProyecto(String descProyecto) {
        this.descProyecto = descProyecto;
    }

    @Basic
    @Column(name = "herramientas")
    public String getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(String herramientas) {
        this.herramientas = herramientas;
    }

    @Basic
    @Column(name = "Tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "FechaInicio")
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "FechaFin")
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyectosLps that = (ProyectosLps) o;
        return idProyectoLps == that.idProyectoLps &&
                idcliente == that.idcliente &&
                Objects.equals(nombreProyecto, that.nombreProyecto) &&
                Objects.equals(descProyecto, that.descProyecto) &&
                Objects.equals(herramientas, that.herramientas) &&
                Objects.equals(tipo, that.tipo) &&
                Objects.equals(fechaInicio, that.fechaInicio) &&
                Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProyectoLps, idcliente, nombreProyecto, descProyecto, herramientas, tipo, fechaInicio, fechaFin);
    }
}
