package ar.com.tecnosoftware.somos.rubro.repository.impl;

import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import ar.com.tecnosoftware.somos.rubro.repository.RubroRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RubroRepositoryImpl implements RubroRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Rubro rubro) {
        entityManager.persist(rubro);
    }

    @Override
    public Rubro buscar(int id) {
        return entityManager.find(Rubro.class, id);
    }

    @Override
    public List<Rubro> buscar(String extension) {
        String hql = "FROM Rubro " + extension;
        return (List<Rubro>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Rubro rubro) {
        rubro.setBaja(true);
        entityManager.flush();
    }

    @Override
    public void editar(Rubro rubro) {
        entityManager.merge(rubro);
    }
}
