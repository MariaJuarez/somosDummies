package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.LiderServicio;
import ar.com.tecnosoftware.somos.repository.LiderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LiderRepositoryImpl implements LiderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Object entity) {
        entityManager.persist(entity);
    }

    @Override
    public Object buscar(int id) {
        return entityManager.find(LiderServicio.class,id);
    }

    @Override
    public List buscarTodos() {
        String hql = "FROM LiderServicio WHERE baja = false";
        return (List<LiderServicio>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Object entity) {
        LiderServicio liderServicio = (LiderServicio) entity;
        liderServicio.setBaja(true);
        entityManager.flush();
    }
}
