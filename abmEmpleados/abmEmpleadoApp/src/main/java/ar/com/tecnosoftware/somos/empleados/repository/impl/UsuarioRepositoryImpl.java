package ar.com.tecnosoftware.somos.empleados.repository.impl;

import ar.com.tecnosoftware.somos.empleados.entity.Usuario;
import ar.com.tecnosoftware.somos.empleados.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public Usuario buscar(Usuario usuario) {
        return entityManager.find(Usuario.class, usuario.getId());
    }
}
