package ar.com.tecnosoftware.somos.usuario.repository.impl;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.usuario.entity.Usuario;
import ar.com.tecnosoftware.somos.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public Usuario buscar(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscar(String extension) {
        String hql = "FROM Usuario " + extension;
        return (List<Usuario>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Usuario usuario) {
        usuario.setBaja(true);
        entityManager.flush();
    }

    @Override
    public Usuario buscarUsuarioConEmpleado(int idEmpleado) {
        String hql = "FROM Usuario WHERE empleado = " + idEmpleado;
        return (Usuario) entityManager.createQuery(hql).getSingleResult();
    }

    @Override
    public void darBajaEmpleadoDeUsuario(Usuario usuario, Empleado empleado) {
        usuario.setEmpleado(empleado);
        entityManager.merge(usuario);
    }
}