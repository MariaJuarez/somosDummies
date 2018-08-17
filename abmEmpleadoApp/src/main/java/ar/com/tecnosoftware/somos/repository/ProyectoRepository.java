package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Cliente;
import ar.com.tecnosoftware.somos.entity.Metodologia;
import ar.com.tecnosoftware.somos.entity.Proyecto;
import ar.com.tecnosoftware.somos.entity.TipoProyecto;

import java.util.List;

public interface ProyectoRepository extends Repository<Proyecto> {

    List<Proyecto> buscarProyectosConCliente(int idCliente);

    List<Proyecto> buscarProyectosConMetodologia(int idMetodologia);

    void darBajaMetodologiaDeProyecto(Proyecto proyecto, Metodologia metodologia);

    List<Proyecto> buscarProyectosConTipoProyecto(int idTipoProyecto);

    void darBajaTipoProyectoDeProyecto(Proyecto proyecto, TipoProyecto tipoProyecto);

    List<Proyecto> buscarProyectosConTecnologia(int idTecnologia);

    void darBajaTecnologiaDeProyecto(Proyecto proyecto);

}
