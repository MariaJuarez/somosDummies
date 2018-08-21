package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Rubro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRubro")
    private int idRubro;

    @Basic
    @Column(name = "DescRubro")
    private String descRubro;

    @Basic
    @Column(name = "baja")
    private boolean baja;
}
