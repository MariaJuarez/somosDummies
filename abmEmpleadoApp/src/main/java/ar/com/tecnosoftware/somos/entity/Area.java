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
    @Column(name = "id_centro_costo")
    private int id_centro_costo;

    @Basic
    @Column(name = "desc_centro_costo")
    private String desc_centro_costo;

    @Basic
    @Column(name = "baja")
    private boolean baja;

}
