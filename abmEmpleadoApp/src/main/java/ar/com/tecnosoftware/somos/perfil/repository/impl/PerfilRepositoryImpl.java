package ar.com.tecnosoftware.somos.perfil.repository.impl;

import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.perfil.repository.PerfilRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PerfilRepositoryImpl implements PerfilRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Perfil perfil) {
        entityManager.persist(perfil);
    }

    @Override
    public Perfil buscar(int id) {
        return entityManager.find(Perfil.class, id);
    }

    @Override
    public List<Perfil> buscar(String extension) {
        String hql = "FROM Perfil " + extension;
        return (List<Perfil>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Perfil darBaja(Perfil perfil) {
        perfil.setBaja(true);
        return entityManager.merge(perfil);
    }

    @Override
    public Perfil editar(Perfil perfil) {
        return entityManager.merge(perfil);
    }
}
