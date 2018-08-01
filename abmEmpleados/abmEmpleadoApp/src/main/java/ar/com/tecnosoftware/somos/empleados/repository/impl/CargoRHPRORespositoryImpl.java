package ar.com.tecnosoftware.somos.empleados.repository.impl;

import ar.com.tecnosoftware.somos.empleados.entity.CargoRHPRO;
import ar.com.tecnosoftware.somos.empleados.repository.CargoRHPRORepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
