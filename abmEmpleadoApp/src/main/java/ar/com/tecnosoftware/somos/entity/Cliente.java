package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCliente")
    private int idCliente;

    @Basic
    @Column(name = "DescCliente")
    private String descCliente;

    @Basic
    @Column(name = "IdLDS")
    private int idLds;

    @Basic
    @Column(name = "DescClienteLPS")
    private String descClienteLps;

    @Basic
    @Column(name = "Grupo")
    private String grupo;

    @Basic
    @Column(name = "Baja")
    private boolean baja;

    @OneToMany
    private List<Empleado> empleadosCliente;

    @OneToOne
    @JoinColumn(name = "IdRubro", referencedColumnName = "IdRubro")
    private Rubro rubro;

}
