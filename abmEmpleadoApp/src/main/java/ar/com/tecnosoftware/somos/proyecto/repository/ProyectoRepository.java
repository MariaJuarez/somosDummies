package ar.com.tecnosoftware.somos.proyecto.repository;

import ar.com.tecnosoftware.somos.metodologia.entity.Metodologia;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.filtro.FiltroProyecto;
import ar.com.tecnosoftware.somos.repository.Repository;
import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import org.hibernate.Session;

import java.util.List;

public interface ProyectoRepository extends Repository<Proyecto> {

    Proyecto darBajaMetodologiaDeProyecto(Proyecto proyecto, Metodologia metodologia);

    Proyecto darBajaTipoProyectoDeProyecto(Proyecto proyecto, TipoProyecto tipoProyecto);

    List<Proyecto> buscarProyectosConTecnologia(int idTecnologia);

    Proyecto darBajaTecnologiaDeProyecto(Proyecto proyecto);

    List<Proyecto> buscarPorFiltro(FiltroProyecto filtroProyecto);

    void activarFiltros(FiltroProyecto filtroProyecto, Session session);

    void desactivarFiltros(Session session);

}
