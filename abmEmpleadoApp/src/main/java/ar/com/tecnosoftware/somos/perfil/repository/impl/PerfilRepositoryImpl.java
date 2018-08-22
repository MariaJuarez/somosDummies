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
    public List<Perfil> buscarTodos() {
        String hql = "FROM perfil WHERE baja = false";
        return (List<Perfil>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Perfil perfil) {
        perfil.setBaja(true);
        entityManager.flush();
    }
}
