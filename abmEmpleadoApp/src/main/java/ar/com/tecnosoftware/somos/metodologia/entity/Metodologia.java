package ar.com.tecnosoftware.somos.metodologia.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Metodologia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodologia")
    private int id;

    @Basic
    @Column(name = "descripcion")
    private String descripcion;

    @Basic
    @Column(name = "baja")
    private boolean baja;
}
