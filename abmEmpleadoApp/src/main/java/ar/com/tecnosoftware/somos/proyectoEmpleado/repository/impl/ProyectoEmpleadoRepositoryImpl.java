package ar.com.tecnosoftware.somos.proyectoEmpleado.repository.impl;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.repository.ProyectoEmpleadoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProyectoEmpleadoRepositoryImpl implements ProyectoEmpleadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(ProyectoEmpleado proyectoEmpleado) {
        entityManager.persist(proyectoEmpleado);
    }

    @Override
    public ProyectoEmpleado buscar(int id) {
        return entityManager.find(ProyectoEmpleado.class, id);
    }

    @Override
    public List<ProyectoEmpleado> buscar(String extension) {
        String hql = "FROM ProyectoEmpleado " + extension ;
        return (List<ProyectoEmpleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(ProyectoEmpleado proyectoEmpleado) {
        proyectoEmpleado.setBaja(true);
        entityManager.flush();
    }

    @Override
    public void darBajaCargoDeProyectoEmpleado(ProyectoEmpleado proyectoEmpleado, Cargo cargo) {
        proyectoEmpleado.setCargo(cargo);
        entityManager.merge(proyectoEmpleado);
    }
}
