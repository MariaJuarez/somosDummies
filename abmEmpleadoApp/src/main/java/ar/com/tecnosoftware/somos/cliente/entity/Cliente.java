package ar.com.tecnosoftware.somos.cliente.entity;

import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "descripcion_cliente")
    private String descripcion;

    @Basic
    @Column(name = "grupo")
    private String grupo;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @ManyToOne
    @JoinColumn(name = "id_rubro", referencedColumnName = "id_rubro")
    private Rubro rubro;

}
