package ar.com.tecnosoftware.somos.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
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
