package ar.com.tecnosoftware.somos.entity;

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
    @Column(name = "IdLDS")
    private short idLds;

    @Basic
    @Column(name = "Nombre")
    private String nombre;

    @Basic
    @Column(name = "Baja")
    private boolean baja;
}
