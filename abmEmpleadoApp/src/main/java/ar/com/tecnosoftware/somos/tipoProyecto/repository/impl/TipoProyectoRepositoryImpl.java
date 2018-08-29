package ar.com.tecnosoftware.somos.tipoProyecto.repository.impl;

import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import ar.com.tecnosoftware.somos.tipoProyecto.repository.TipoProyectoRepository;
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
    public List<TipoProyecto> buscar(String extension) {
        String hql = "FROM TipoProyecto " + extension;
        return (List<TipoProyecto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public TipoProyecto darBaja(TipoProyecto tipoProyecto) {
        tipoProyecto.setBaja(true);
        return entityManager.merge(tipoProyecto);
    }

    @Override
    public TipoProyecto editar(TipoProyecto tipoProyecto) {
        return entityManager.merge(tipoProyecto);
    }
}
