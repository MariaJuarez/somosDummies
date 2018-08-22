package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.repository.AreaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AreaRepositoryImpl implements AreaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Area area) {
        entityManager.persist(area);
    }

    @Override
    public void darBaja(Area area) {
        area.setBaja(true);
        entityManager.flush();
    }

    @Override
    public Area buscar(int id) {
        return entityManager.find(Area.class, id);
    }

    @Override
    public List<Area> buscarTodos() {
        String hql = "FROM area WHERE baja = false";
        return (List<Area>) entityManager.createQuery(hql).getResultList();
    }
}
