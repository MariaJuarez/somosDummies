package ar.com.tecnosoftware.somos.tecnologia.entity;

import ar.com.tecnosoftware.somos.senority.Senority;
import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Tecnologia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnologia")
    private int id;

    @Basic
    @Column(name = "descripcion")
    private String descripcion;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @ManyToOne
    @JoinColumn(name = "id_tipo_tecnologia", referencedColumnName = "id_tipo_tecnologia", nullable = false)
    private TipoTecnologia tipo;

    @Enumerated(EnumType.ORDINAL)
    private Senority senority;

}
