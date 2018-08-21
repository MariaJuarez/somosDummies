package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class TipoProyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoProyecto")
    private int idTipoProyecto;

    @Basic
    @Column(name = "DescTipoProyecto")
    private String descTipoProyecto;

    @Basic
    @Column(name = "baja")
    private boolean baja;
}
