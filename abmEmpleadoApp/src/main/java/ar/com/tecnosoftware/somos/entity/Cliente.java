package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
    @JoinColumn(name="IdEmpleado", referencedColumnName = "IdEmpleado")
    private List<Empleado> empleadosCliente;

    @OneToOne
    @JoinColumn(name = "IdRubro", referencedColumnName = "IdRubro")
    private Rubro rubro;

}
