package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Entity
public class ProyectosLps implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProyectoLPS")
    private int idProyectoLps;

    @Basic
    @Column(name = "idcliente")
    private int idcliente;

    @Basic
    @Column(name = "nombreProyecto")
    private String nombreProyecto;

    @Basic
    @Column(name = "descProyecto")
    private String descProyecto;

    @Basic
    @Column(name = "herramientas")
    private String herramientas;

    @Basic
    @Column(name = "Tipo")
    private String tipo;

    @Basic
    @Column(name = "FechaInicio")
    private Date fechaInicio;

    @Basic
    @Column(name = "FechaFin")
    private Date fechaFin;
}
