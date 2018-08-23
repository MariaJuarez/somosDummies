package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.Area;
import ar.com.tecnosoftware.somos.entity.Empleado;
import ar.com.tecnosoftware.somos.entity.Perfil;
import ar.com.tecnosoftware.somos.entity.Tecnologia;
import ar.com.tecnosoftware.somos.repository.EmpleadoRepository;
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
        String hql = "FROM Empleado WHERE baja = false";
        return (List<Empleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Empleado empleado) {
        empleado.setBaja(true);
        entityManager.flush();
    }

    @Override
    public List<Empleado> buscarEmpleadosConArea(int idArea) {
        String hql = "FROM Empleado WHERE area = " + idArea;
        return (List<Empleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBajaAreaDeEmpleado(Empleado empleado, Area area) {
      //  empleado.setArea(area);
        entityManager.merge(empleado);
    }

    @Override
    public List<Empleado> buscarEmpleadosConPerfil(int idPerfil) {
        String hql = "FROM Empleado WHERE perfil = " + idPerfil;
        return (List<Empleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBajaPerfilDeEmpleado(Empleado empleado, Perfil perfil) {
        empleado.setPerfil(perfil);
        entityManager.merge(empleado);
    }

    @Override
    public List<Empleado> buscarEmpleadosConTecnologia(int idTecnologia) {
        String hql = "SELECT e FROM Empleado e JOIN e.tecnologias t WHERE t.idTecnologia = " + idTecnologia;
        return (List<Empleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBajaTecnologiaDeEmpleado(Empleado empleado) {
        entityManager.merge(empleado);
    }
}
