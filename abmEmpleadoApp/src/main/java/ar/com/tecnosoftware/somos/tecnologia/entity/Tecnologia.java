package ar.com.tecnosoftware.somos.tecnologia.entity;

import ar.com.tecnosoftware.somos.senority.Senority;
import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class Tecnologia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnologia")
    private int id;

    @Basic
    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_tipo_tecnologia", referencedColumnName = "id_tipo_tecnologia")
    private TipoTecnologia tipo;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Senority senority;

}
