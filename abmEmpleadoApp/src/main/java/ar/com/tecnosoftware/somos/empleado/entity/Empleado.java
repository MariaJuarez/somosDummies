package ar.com.tecnosoftware.somos.empleado.entity;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.senority.Senority;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@FilterDefs({
        @FilterDef(name = "filtroBaja", parameters = {
                @ParamDef(name = "baja", type = "boolean")
        }),
        @FilterDef(name = "filtroLegajo", parameters = {
                @ParamDef(name = "legajo", type = "integer")
        }),
        @FilterDef(name = "filtroNombres", parameters = {
                @ParamDef(name = "nombres", type = "string")
        }),
        @FilterDef(name = "filtroApellidos", parameters = {
                @ParamDef(name = "apellidos", type = "string")
        }),
        @FilterDef(name = "filtroFechaIngreso", parameters = {
                @ParamDef(name = "fechaIngreso", type = "date")
        }),
        @FilterDef(name = "filtroFechaEgreso", parameters = {
                @ParamDef(name = "fechaEgreso", type = "date")
        }),
        @FilterDef(name = "filtroPromovido", parameters = {
                @ParamDef(name = "promovido", type = "boolean")
        }),
        @FilterDef(name = "filtroArea", parameters = {
                @ParamDef(name = "idArea", type = "integer")
        })
})
@Filters({
        @Filter(name = "filtroBaja", condition = ":baja = baja"),
        @Filter(name = "filtroLegajo", condition = ":legajo = legajo"),
        @Filter(name = "filtroNombres", condition = ":nombres = nombres"),
        @Filter(name = "filtroApellidos", condition = ":apellidos = apellidos"),
        @Filter(name = "filtroFechaIngreso", condition = ":fechaIngreso = fecha_ingreso"),
        @Filter(name = "filtroFechaEgreso", condition = ":fechaEgreso = fecha_egreso"),
        @Filter(name = "filtroPromovido", condition = ":promovido = promovido_lps"),
        @Filter(name = "filtroArea", condition = ":idArea = id_centro_costo")
})
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
