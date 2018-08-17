package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Tecnologia;
import ar.com.tecnosoftware.somos.entity.TipoTecnologia;

import java.util.List;

public interface TecnologiaRepository extends Repository<Tecnologia> {

    List<Tecnologia> buscarTecnologiasConTipoTecnologia(int idTipoTecnologia);

    void darBajaTipoTecnologiaDeTecnologia(Tecnologia tecnologia, TipoTecnologia tipoTecnologia);

}
