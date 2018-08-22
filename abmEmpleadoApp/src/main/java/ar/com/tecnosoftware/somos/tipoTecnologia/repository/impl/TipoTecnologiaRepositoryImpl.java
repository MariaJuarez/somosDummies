package ar.com.tecnosoftware.somos.tipoTecnologia.repository.impl;

import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;
import ar.com.tecnosoftware.somos.tipoTecnologia.repository.TipoTecnologiaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TipoTecnologiaRepositoryImpl implements TipoTecnologiaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(TipoTecnologia tipoTecnologia) {
        entityManager.persist(tipoTecnologia);
    }

    @Override
    public TipoTecnologia buscar(int id) {
        return entityManager.find(TipoTecnologia.class, id);
    }

    @Override
    public List<TipoTecnologia> buscarTodos() {
        String hql = "FROM tipoTecnologia WHERE baja = false";
        return (List<TipoTecnologia>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(TipoTecnologia tipoTecnologia) {
        tipoTecnologia.setBaja(true);
        entityManager.flush();
    }
}
