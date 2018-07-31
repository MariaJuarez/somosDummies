package ar.com.tecnosoftware.somos.empleados.repository.impl;

import ar.com.tecnosoftware.somos.empleados.entity.Cliente;
import ar.com.tecnosoftware.somos.empleados.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
