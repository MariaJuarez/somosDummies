package ar.com.tecnosoftware.somos.liderServicio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class LiderServicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lds")
    private short idLds;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "baja")
    private boolean baja;
}
