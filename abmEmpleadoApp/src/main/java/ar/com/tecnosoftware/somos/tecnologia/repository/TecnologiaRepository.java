package ar.com.tecnosoftware.somos.tecnologia.repository;

import ar.com.tecnosoftware.somos.repository.Repository;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;

import java.util.List;

public interface TecnologiaRepository extends Repository<Tecnologia> {

    Tecnologia darBajaTipoTecnologiaDeTecnologia(Tecnologia tecnologia, TipoTecnologia tipoTecnologia);

}
