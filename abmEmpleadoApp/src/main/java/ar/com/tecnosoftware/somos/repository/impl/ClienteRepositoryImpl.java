package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.Cliente;
import ar.com.tecnosoftware.somos.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Object entity) {
        entityManager.persist(entity);
    }

    @Override
    public Cliente buscar(int id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        String hql = "FROM Cliente WHERE baja = false";
        return (List<Cliente>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Object entity) {
        Cliente cliente = (Cliente) entity;
        cliente.setBaja(true);
        entityManager.flush();
    }
}
