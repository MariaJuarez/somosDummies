package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCentroCosto")
    private int idCentroCosto;

    @Basic
    @Column(name = "DescCentroCosto")
    private String descCentroCosto;

    @Basic
    @Column(name = "Baja")
    private boolean baja;

}
