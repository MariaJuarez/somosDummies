package ar.com.tecnosoftware.somos.proyectoEmpleado.entity;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
public class ProyectoEmpleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto_empleado")
    private int id;

    @Basic
    @NotBlank
    @Column(name = "tareas_proyecto")
    private String tareas;

    @Basic
    @NotNull
    @Column(name = "fecha_inicio")
    private Date inicio;

    @Basic
    @Column(name = "fecha_fin")
    private Date fin;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    private Proyecto proyecto;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    private Cargo cargo;

}
