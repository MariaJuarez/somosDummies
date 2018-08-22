package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.metodologia.entity.Metodologia;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import ar.com.tecnosoftware.somos.repository.ProyectoRepository;
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
    public List<Proyecto> buscarTodos() {
        String hql = "FROM proyecto WHERE baja = false";
        return (List<Proyecto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Proyecto proyecto) {
        proyecto.setBaja(true);
        entityManager.flush();
    }

    @Override
    public List<Proyecto> buscarProyectosConCliente(int idCliente) {
        String hql = "FROM proyecto WHERE cliente = " + idCliente;
        return (List<Proyecto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Proyecto> buscarProyectosConMetodologia(int idMetodologia) {
        String hql = "FROM proyecto WHERE metodologia = " + idMetodologia;
        return (List<Proyecto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBajaMetodologiaDeProyecto(Proyecto proyecto, Metodologia metodologia) {
        proyecto.setMetodologia(metodologia);
        entityManager.merge(proyecto);
    }

    @Override
    public List<Proyecto> buscarProyectosConTipoProyecto(int idTipoProyecto) {
        String hql = "FROM proyecto WHERE tipo = " + idTipoProyecto;
        return (List<Proyecto>) entityManager.createQuery(hql).getResultList();
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
}
