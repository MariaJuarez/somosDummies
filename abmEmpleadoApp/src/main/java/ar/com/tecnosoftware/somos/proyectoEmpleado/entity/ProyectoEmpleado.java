package ar.com.tecnosoftware.somos.proyectoEmpleado.entity;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
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
    @Column(name = "id_proyecto_empleado")
    private int id;

    @Basic
    @Column(name = "tareas_proyecto")
    private String tareas;

    @Basic
    @Column(name = "fecha_inicio")
    private Date inicio;

    @Basic
    @Column(name = "fecha_fin")
    private Date fin;

    @Basic
    @Column(name = "fecha_relevamiento")
    private Date relevamiento;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", nullable = false)
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo", nullable = false)
    private Cargo cargo;

}
