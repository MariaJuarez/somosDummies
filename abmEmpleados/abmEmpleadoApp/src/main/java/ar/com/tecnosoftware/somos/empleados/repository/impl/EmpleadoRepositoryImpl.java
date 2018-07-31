package ar.com.tecnosoftware.somos.empleados.repository.impl;

import ar.com.tecnosoftware.somos.empleados.entity.Empleado;
import ar.com.tecnosoftware.somos.empleados.repository.EmpleadoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmpleadoRepositoryImpl implements EmpleadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Empleado empleado) {
        entityManager.persist(empleado);
    }

}
