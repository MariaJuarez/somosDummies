package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.Usuario;
import ar.com.tecnosoftware.somos.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Object entity) {
        entityManager.persist(entity);
    }

    @Override
    public Usuario buscar(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        String hql = "FROM Usuario WHERE baja = false";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Object entity) {
        Usuario usuario = (Usuario) entity;
        usuario.setBaja(true);
        entityManager.flush();
    }
}
