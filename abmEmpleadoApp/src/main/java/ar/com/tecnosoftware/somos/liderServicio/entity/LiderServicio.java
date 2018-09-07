package ar.com.tecnosoftware.somos.liderServicio.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
public class LiderServicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lds")
    private short idLds;

    @Basic
    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "baja")
    private boolean baja;
}
