package ar.com.tecnosoftware.somos.empleados.repository.impl;

import ar.com.tecnosoftware.somos.empleados.entity.CentroCosto;
import ar.com.tecnosoftware.somos.empleados.repository.CentroCostoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CentroCostoRepositoryImpl implements CentroCostoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(CentroCosto centroCosto) {
        entityManager.persist(centroCosto);
    }

    @Override
    public CentroCosto buscar(CentroCosto centroCosto) {
        return entityManager.find(CentroCosto.class, centroCosto.getId());
    }
}
