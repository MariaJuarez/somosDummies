package ar.com.tecnosoftware.somos.proyectoEmpleado.repository.impl;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.repository.ProyectoEmpleadoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public List<Empleado> buscarEmpleadosPorFiltro(String hql, FiltroEmpleado filtroEmpleado, int tipoFiltro) {
        Query query = entityManager.createQuery(hql);

        switch (tipoFiltro){
            case 1:
                query.setParameter("proyecto", filtroEmpleado.getProyecto());
                break;
            case 2:
                query.setParameter("tipoProyecto", filtroEmpleado.getTipoProyecto());
                break;
            case 3:
                query.setParameter("clientes", filtroEmpleado.getClientes());
                break;
            case 4:
                query.setParameter("rubro", filtroEmpleado.getRubro());
                break;
            case 5:
                query.setParameter("tipoProyecto", filtroEmpleado.getTipoProyecto());
                query.setParameter("clientes", filtroEmpleado.getClientes());
                break;
            case 6:
                query.setParameter("tipoProyecto", filtroEmpleado.getTipoProyecto());
                query.setParameter("rubro", filtroEmpleado.getRubro());
                break;
            case 7:
                query.setParameter("clientes", filtroEmpleado.getClientes());
                query.setParameter("rubro", filtroEmpleado.getRubro());
                break;
            case 9:
                query.setParameter("tipoProyecto", filtroEmpleado.getTipoProyecto());
                query.setParameter("clientes", filtroEmpleado.getClientes());
                query.setParameter("rubro", filtroEmpleado.getRubro());
                break;
        }

        return (List<Empleado>) query.getResultList();
    }
}
