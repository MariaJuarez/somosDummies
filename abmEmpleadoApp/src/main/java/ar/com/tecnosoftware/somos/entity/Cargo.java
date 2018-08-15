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
    @Column(name = "IdCargo")
    private int idCargo;

    @Basic
    @Column(name = "DescCargo")
    private String descCargo;

    @Basic
    @Column(name = "Baja")
    private boolean baja;
}
