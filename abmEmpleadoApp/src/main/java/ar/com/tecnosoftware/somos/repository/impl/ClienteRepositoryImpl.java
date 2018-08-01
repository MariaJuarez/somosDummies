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
    public void guardar(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    public Cliente buscar(Cliente cliente) {
        return entityManager.find(Cliente.class, cliente.getId());
    }

    @Override
    public List<Cliente> buscarTodos() {
        String hql = "FROM Cliente WHERE baja = false";
        return (List<Cliente>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Cliente cliente) {
        cliente.setBaja(true);
        entityManager.flush();
    }
}
