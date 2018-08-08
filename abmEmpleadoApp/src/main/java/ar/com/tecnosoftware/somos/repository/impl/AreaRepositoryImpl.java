package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.Area;
import ar.com.tecnosoftware.somos.repository.AreaRepository;
import org.hibernate.query.Query;
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
    public Area buscar(int id) {
        return entityManager.find(Area.class, id);
    }

    @Override
    public List<Area> buscarTodos() {

        Query query = (Query) entityManager.createQuery("FROM Area WHERE baja = false");
        List<Area> areas = query.list();
        return areas;
    }

    @Override
    public void darBaja(Area area) {
        area.setBaja(true);
        entityManager.flush();
    }
}
