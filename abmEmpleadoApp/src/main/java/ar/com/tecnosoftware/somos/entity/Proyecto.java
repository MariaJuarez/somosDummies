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
    @Column(name = "id_proyecto")
    private int id;

    @Basic
    @Column(name = "JIRA")
    private String jira;

    @Basic
    @Column(name = "CRM")
    private int crm;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "descripcion")
    private String descripcion;

    @Basic
    @Column(name = "lider")
    private String lider;

    @Basic
    @Column(name = "objetivo")
    private String objetivo;

    @Basic
    @Column(name = "externo")
    private boolean externo;

    @Basic
    @Column(name = "equipo_trabajo")
    private String equipo;

    @Basic
    @Column(name = "fecha_inicio")
    private Date inicio;

    @Basic
    @Column(name = "fecha_fin")
    private Date fin;

    @Basic
    @Column(name = "usuarios")
    private String usuarios;

    @Basic
    @Column(name = "area_solicitante")
    private String solicitante;

    @Basic
    @Column(name = "roles")
    private String roles;

    @Basic
    @Column(name = "requerimiento_funcional")
    private String requerimiento;

    @Basic
    @Column(name = "observaciones")
    private String observaciones;

    @Basic
    @Column(name = "promovido_lps")
    private boolean promovido;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_metodologia", referencedColumnName = "id_metodologia")
    private Metodologia metodologia;

    @ManyToOne
    @JoinColumn(name = "id_tipo_proyecto", referencedColumnName = "id_tipo_proyecto")
    private TipoProyecto tipo;

    @ManyToMany
    @JoinTable(name = "proyectos_tecnologias",
            joinColumns = @JoinColumn(name = "id_proyecto"),
            inverseJoinColumns = @JoinColumn(name = "id_tecnologia"))
    private List<Tecnologia> tecnologias;

}
