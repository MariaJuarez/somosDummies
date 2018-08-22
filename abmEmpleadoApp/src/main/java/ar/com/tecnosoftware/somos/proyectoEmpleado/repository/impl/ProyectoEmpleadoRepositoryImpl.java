package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.repository.ProyectoEmpleadoRepository;
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
    public List<ProyectoEmpleado> buscarTodos() {
        String hql = "FROM proyectoEmpleado WHERE baja = false";
        return (List<ProyectoEmpleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(ProyectoEmpleado proyectoEmpleado) {
        proyectoEmpleado.setBaja(true);
        entityManager.flush();
    }

    @Override
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConEmpleado(int idEmpleado) {
        String hql = "FROM proyectoEmpleado WHERE empleado = " + idEmpleado;
        return (List<ProyectoEmpleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConProyecto(int idProyecto) {
        String hql = "FROM proyectoEmpleado WHERE proyecto = " + idProyecto;
        return (List<ProyectoEmpleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConCargo(int idCargo) {
        String hql = "FROM proyectoEmpleado WHERE cargo = " + idCargo;
        return (List<ProyectoEmpleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBajaCargoDeProyectoEmpleado(ProyectoEmpleado proyectoEmpleado, Cargo cargo) {
        proyectoEmpleado.setCargo(cargo);
        entityManager.merge(proyectoEmpleado);
    }
}
