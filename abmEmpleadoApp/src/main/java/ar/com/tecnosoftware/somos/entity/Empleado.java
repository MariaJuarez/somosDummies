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
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEmpleado")
    private int idEmpleado;

    @Basic
    @Column(name = "Legajo")
    private int legajo;

    @Basic
    @Column(name = "Nombres")
    private String nombres;

    @Basic
    @Column(name = "Apellidos")
    private String apellidos;

    @Basic
    @Column(name = "Cuil")
    private String cuil;

    @Basic
    @Column(name = "Responsable")
    private String responsable;

    @Basic
    @Column(name = "FehaIngreso")
    private Date fehaIngreso;

    @Basic
    @Column(name = "FechaEgreso")
    private Date fechaEgreso;

    @Basic
    @Column(name = "DomicilioLaboral")
    private String domicilioLaboral;

    @Basic
    @Column(name = "Observaciones")
    private String observaciones;

    @Basic
    @Column(name = "PromovidoLPS")
    private boolean promovidoLps;

    @Basic
    @Column(name = "Email")
    private String email;

    @Basic
    @Column(name = "Telefono")
    private String telefono;

    @Basic
    @Column(name = "Baja")
    private boolean baja;

    @OneToOne
    @JoinColumn(name = "IdCargorhpro", referencedColumnName = "IdCargorhpro")
    private Cargo cargo;

    @OneToOne
    @JoinColumn(name = "IdCentroCosto", referencedColumnName = "IdCentroCosto")
    private Area area;

    @OneToOne
    @JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
    private Usuario usuario;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.ORDINAL)
    private Senority senority;

    @ManyToMany
    @JoinTable(name = "empleadosTecnologias",
            joinColumns = @JoinColumn(name = "idEmpleado"),
            inverseJoinColumns = @JoinColumn(name = "idTecnologia"))
    private List<Tecnologia> tecnologias;

}
