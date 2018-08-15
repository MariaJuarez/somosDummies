package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class TipoTecnologia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoTecnologia")
    private int idTipoTecnologia;

    @Basic
    @Column(name = "DescTipoTecnologia")
    private String descTipoTecnologia;

    @Basic
    @Column(name = "baja")
    private boolean baja;

}
