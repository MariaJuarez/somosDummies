package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Entity
public class ProyectoEmpleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProyectoEmpleado")
    private int idProyectoEmpleado;

    @Basic
    @Column(name = "AnioLPS")
    private int anioLps;

    @Basic
    @Column(name = "TareasProyecto")
    private String tareasProyecto;

    @Basic
    @Column(name = "FechaInicio")
    private Date fechaInicio;

    @Basic
    @Column(name = "FechaFin")
    private Date fechaFin;

    @Basic
    @Column(name = "FechaRelevamiento")
    private Date fechaRelevamiento;

    @ManyToOne
    @JoinColumn(name = "IdEmpleado", referencedColumnName = "IdEmpleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "IdProyecto", referencedColumnName = "IdProyecto", nullable = false)
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "IdCargo", referencedColumnName = "IdCargo", nullable = false)
    private Cargo cargo;

}
