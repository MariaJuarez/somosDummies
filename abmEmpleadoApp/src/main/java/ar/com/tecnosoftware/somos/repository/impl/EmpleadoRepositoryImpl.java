package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.Area;
import ar.com.tecnosoftware.somos.entity.Empleado;
import ar.com.tecnosoftware.somos.repository.EmpleadoRepository;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmpleadoRepositoryImpl implements EmpleadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Empleado empleado) {
        entityManager.persist(empleado);
    }

    @Override
    public Empleado buscar(int id) {
        return entityManager.find(Empleado.class, id);
    }

    @Override
    public List<Empleado> buscarTodos() {
        Query query = (Query) entityManager.createQuery("FROM Empleado WHERE baja = false");
        List<Empleado> empleados = query.list();
        return empleados;
    }

    @Override
    public void darBaja(Empleado empleado) {
        empleado.setBaja(true);
        entityManager.flush();
    }
}
