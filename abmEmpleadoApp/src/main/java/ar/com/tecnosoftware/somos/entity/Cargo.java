package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
public class Cargo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCargorhpro")
    private int idCargoRhpro;

    @Basic
    @Column(name = "DescCargoRHPRO")
    private String descCargoRhpro;

    @Basic
    @Column(name = "Baja")
    private boolean baja;
}
