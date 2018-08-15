package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.LiderServicio;
import ar.com.tecnosoftware.somos.repository.LiderServicioRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LiderServicioRepositoryImpl implements LiderServicioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(LiderServicio liderServicio) {
        entityManager.persist(liderServicio);
    }

    @Override
    public LiderServicio buscar(int id) {
        return entityManager.find(LiderServicio.class,id);
    }

    @Override
    public List buscarTodos() {
        String hql = "FROM LiderServicio WHERE baja = false";
        return (List<LiderServicio>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(LiderServicio liderServicio) {
        liderServicio.setBaja(true);
        entityManager.flush();
    }
}
