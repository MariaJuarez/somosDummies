package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPerfil")
    private int idPerfil;

    @Basic
    @Column(name = "AbrvPerfil")
    private String abrvPerfil;

    @Basic
    @Column(name = "DescPerfil")
    private String descPerfil;

    @Basic
    @Column(name = "baja")
    private boolean baja;
}
