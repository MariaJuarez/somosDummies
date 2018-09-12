package ar.com.tecnosoftware.somos.cargo.repository.impl;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.cargo.repository.CargoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CargoRespositoryImpl implements CargoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Cargo cargo) {
        entityManager.persist(cargo);
    }

    @Override
    public Cargo buscar(int id) {
        return entityManager.find(Cargo.class, id);
    }

    @Override
    public List<Cargo> buscar(String extension) {
        String hql = "FROM Cargo " + extension;
        return (List<Cargo>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Cargo darBaja(Cargo cargo) {
        cargo.setBaja(true);
        return entityManager.merge(cargo);
    }

    @Override
    public Cargo editar(Cargo cargo) {
        return entityManager.merge(cargo);
    }
}
