package ar.com.tecnosoftware.somos.empleado.entity;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.senority.Senority;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
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
    @Column(name = "id_empleado")
    private int id;

    @Basic
    @Column(name = "legajo")
    private int legajo;

    @Basic
    @Column(name = "nombres")
    private String nombres;

    @Basic
    @Column(name = "apellidos")
    private String apellidos;

    @Basic
    @Column(name = "cuil")
    private String cuil;

    @Basic
    @Column(name = "responsable")
    private String responsable;

    @Basic
    @Column(name = "fecha_ingreso")
    private Date ingreso;

    @Basic
    @Column(name = "fecha_egreso")
    private Date egreso;

    @Basic
    @Column(name = "domicilio")
    private String domicilio;

    @Basic
    @Column(name = "observaciones")
    private String observaciones;

    @Basic
    @Column(name = "promovido_lps")
    private boolean promovido;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "telefono")
    private String telefono;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @ManyToOne
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_centro_costo", referencedColumnName = "id_centro_costo")
    private Area area;

    @Enumerated(EnumType.ORDINAL)
    private Senority senority;

    @ManyToMany
    @JoinTable(name = "empleados_tecnologias",
            joinColumns = @JoinColumn(name = "id_empleado"),
            inverseJoinColumns = @JoinColumn(name = "id_tecnologia"))
    private List<Tecnologia> tecnologias;

}
