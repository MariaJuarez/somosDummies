package ar.com.tecnosoftware.somos.metodologia.repository.impl;

import ar.com.tecnosoftware.somos.metodologia.entity.Metodologia;
import ar.com.tecnosoftware.somos.metodologia.repository.MetodologiaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MetodologiaRepositoryImpl implements MetodologiaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Metodologia metodologia) {
        entityManager.persist(metodologia);
    }

    @Override
    public Metodologia buscar(int id) {
        return entityManager.find(Metodologia.class, id);
    }

    @Override
    public List<Metodologia> buscarTodos() {
        String hql = "FROM metodologia WHERE baja = false";
        return (List<Metodologia>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Metodologia metodologia) {
        metodologia.setBaja(true);
        entityManager.flush();
    }
}
