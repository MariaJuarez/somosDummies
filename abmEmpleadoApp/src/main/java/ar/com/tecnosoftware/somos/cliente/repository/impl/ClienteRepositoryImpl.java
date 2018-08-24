package ar.com.tecnosoftware.somos.cliente.repository.impl;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import ar.com.tecnosoftware.somos.cliente.repository.ClienteRepository;
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
    public Cliente buscar(int id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscar(String extension) {
        String hql = "FROM Cliente " + extension;
        return (List<Cliente>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Cliente cliente) {
        cliente.setBaja(true);
        entityManager.flush();
    }

    @Override
    public void darBajaRubroDeCliente(Cliente cliente, Rubro rubro) {
        cliente.setRubro(rubro);
        entityManager.merge(cliente);
    }
}
