package ar.com.tecnosoftware.somos.usuario.entity;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Basic
    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @OneToOne
    @NotNull
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleado empleado;
}
