package ar.com.tecnosoftware.somos.cliente.entity;

import ar.com.tecnosoftware.somos.grupo.Grupo;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id;

    @Basic
    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @NotBlank
    @Column(name = "descripcion_cliente")
    private String descripcion;

    @Column(name = "grupo")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Grupo grupo;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @ManyToOne
    @JoinColumn(name = "id_rubro", referencedColumnName = "id_rubro")
    private Rubro rubro;

}
