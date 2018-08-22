package ar.com.tecnosoftware.somos.area;

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
    private int id;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;

    @Basic
    @Column(name = "baja")
    private boolean baja;

}
