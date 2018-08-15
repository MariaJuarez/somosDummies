package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.Proyecto;
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
        String hql = "FROM Proyecto WHERE baja = false";
        return (List<Proyecto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Proyecto proyecto) {
        proyecto.setBaja(true);
        entityManager.flush();
    }
}
