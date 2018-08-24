package ar.com.tecnosoftware.somos.proyecto.repository.impl;

import ar.com.tecnosoftware.somos.metodologia.entity.Metodologia;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.filtro.FiltroProyecto;
import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import ar.com.tecnosoftware.somos.proyecto.repository.ProyectoRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Proyecto proyecto) {
        entityManager.persist(proyecto);
    }

    @Override
    public Proyecto buscar(int id) {
        return entityManager.find(Proyecto.class, id);
    }

    @Override
    public List<Proyecto> buscar(String extension) {
        String hql = "FROM Proyecto "+ extension;
        return (List<Proyecto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Proyecto proyecto) {
        proyecto.setBaja(true);
        entityManager.flush();
    }

    @Override
    public void darBajaMetodologiaDeProyecto(Proyecto proyecto, Metodologia metodologia) {
        proyecto.setMetodologia(metodologia);
        entityManager.merge(proyecto);
    }

    @Override
    public void darBajaTipoProyectoDeProyecto(Proyecto proyecto, TipoProyecto tipoProyecto) {
        proyecto.setTipo(tipoProyecto);
        entityManager.merge(proyecto);
    }

    @Override
    public List<Proyecto> buscarProyectosConTecnologia(int idTecnologia) {
        String hql = "SELECT p FROM proyecto p JOIN p.tecnologias t WHERE t.idTecnologia = " + idTecnologia;
        return (List<Proyecto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBajaTecnologiaDeProyecto(Proyecto proyecto) {
        entityManager.merge(proyecto);
    }

    @Override
    public List<Proyecto> buscarPorFiltro(FiltroProyecto filtroProyecto) {
        Session session = entityManager.unwrap(Session.class);

        activarFiltros(filtroProyecto, session);

        List<Proyecto> proyectos = buscar("");

        desactivarFiltros(session);

        return proyectos;
    }

    @Override
    public void activarFiltros(FiltroProyecto filtroProyecto, Session session){
        if(filtroProyecto.getFechaInicio() != null){
            session.enableFilter("filtroFechaInicio").setParameter("fechaInicio",filtroProyecto.getFechaInicio());
        }

        if(filtroProyecto.getFechaFin() != null){
            session.enableFilter("filtroFechaFin").setParameter("fechaFin",filtroProyecto.getFechaFin());
        }

        if(filtroProyecto.getCliente() != null){
            session.enableFilter("filtroCliente").setParameter("idCliente",filtroProyecto.getCliente().getId());
        }
    }

    @Override
    public void desactivarFiltros(Session session){
        session.disableFilter("filtroFechaInicio");
        session.disableFilter("filtroFechaFin");
        session.disableFilter("filtroCliente");
    }
}
