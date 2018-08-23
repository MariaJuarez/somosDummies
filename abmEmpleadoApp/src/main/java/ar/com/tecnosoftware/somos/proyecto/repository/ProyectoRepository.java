package ar.com.tecnosoftware.somos.proyecto.repository;

import ar.com.tecnosoftware.somos.metodologia.entity.Metodologia;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.repository.Repository;
import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;

import java.util.List;

public interface ProyectoRepository extends Repository<Proyecto> {

    void darBajaMetodologiaDeProyecto(Proyecto proyecto, Metodologia metodologia);

    void darBajaTipoProyectoDeProyecto(Proyecto proyecto, TipoProyecto tipoProyecto);

    List<Proyecto> buscarProyectosConTecnologia(int idTecnologia);

    void darBajaTecnologiaDeProyecto(Proyecto proyecto);

}
