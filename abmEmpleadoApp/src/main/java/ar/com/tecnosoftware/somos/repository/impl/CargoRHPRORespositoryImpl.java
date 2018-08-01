package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.CargoRHPRO;
import ar.com.tecnosoftware.somos.repository.CargoRHPRORepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CargoRHPRORespositoryImpl implements CargoRHPRORepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(CargoRHPRO cargoRHPRO) {
        entityManager.persist(cargoRHPRO);
    }

    @Override
    public CargoRHPRO buscar(CargoRHPRO cargoRHPRO) {
        return entityManager.find(CargoRHPRO.class, cargoRHPRO.getId());
    }

    @Override
    public List<CargoRHPRO> buscarTodos() {
        String hql = "FROM CargoRHPRO WHERE baja = false";
        return (List<CargoRHPRO>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(CargoRHPRO cargoRHPRO) {
        cargoRHPRO.setBaja(true);
        entityManager.flush();
    }
}
