package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProyecto")
    private int idProyecto;

    @Basic
    @Column(name = "JIRA")
    private String jira;

    @Basic
    @Column(name = "CRM")
    private int crm;

    @Basic
    @Column(name = "Nombre")
    private String nombre;

    @Basic
    @Column(name = "Lider")
    private String lider;

    @Basic
    @Column(name = "Objetivo")
    private String objetivo;

    @Basic
    @Column(name = "Externo")
    private boolean externo;

    @Basic
    @Column(name = "EquipoTrabajo")
    private String equipoTrabajo;

    @Basic
    @Column(name = "FechaInicio")
    private Date fechaInicio;

    @Basic
    @Column(name = "FechaFin")
    private Date fechaFin;

    @Basic
    @Column(name = "Usuarios")
    private String usuarios;

    @Basic
    @Column(name = "AreaSolicitante")
    private String areaSolicitante;

    @Basic
    @Column(name = "Roles")
    private String roles;

    @Basic
    @Column(name = "ReqFuncional")
    private String reqFuncional;

    @Basic
    @Column(name = "Observaciones")
    private String observaciones;

    @Basic
    @Column(name = "PromovidoLPS")
    private boolean promovidoLps;

    @ManyToOne
    @JoinColumn(name = "IdCliente", referencedColumnName = "IdCliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "IdMetodologia", referencedColumnName = "IdMetodologia")
    private Metodologia metodologia;

    @OneToOne
    @JoinColumn(name = "IdTipoProyecto", referencedColumnName = "IdTipoProyecto")
    private TipoProyecto tipoProyecto;

    @ManyToMany
    @JoinTable(name = "proyectosTecnologias",
            joinColumns = @JoinColumn(name = "idProyecto"),
            inverseJoinColumns = @JoinColumn(name = "idTecnologia"))
    private List<Tecnologia> tecnologias;

}
