package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.Metodologia;
import ar.com.tecnosoftware.somos.repository.MetodologiaRepository;
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
        String hql = "FROM Metodologia WHERE baja = false";
        return (List<Metodologia>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Metodologia metodologia) {
        metodologia.setBaja(true);
        entityManager.flush();
    }
}
