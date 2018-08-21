package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.TipoProyecto;
import ar.com.tecnosoftware.somos.repository.TipoProyectoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TipoProyectoRepositoryImpl implements TipoProyectoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(TipoProyecto tipoProyecto) {
        entityManager.persist(tipoProyecto);
    }

    @Override
    public TipoProyecto buscar(int id) {
        return entityManager.find(TipoProyecto.class, id);
    }

    @Override
    public List<TipoProyecto> buscarTodos() {
        String hql = "FROM TipoProyecto WHERE baja = false";
        return (List<TipoProyecto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(TipoProyecto tipoProyecto) {
        tipoProyecto.setBaja(true);
        entityManager.flush();
    }
}
