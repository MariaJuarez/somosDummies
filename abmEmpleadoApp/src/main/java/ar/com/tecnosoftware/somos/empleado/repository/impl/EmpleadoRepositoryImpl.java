package ar.com.tecnosoftware.somos.empleado.repository.impl;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.empleado.repository.EmpleadoRepository;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
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
    public List<Empleado> buscar(String extension) {
        String hql = "FROM Empleado " + extension;
        return (List<Empleado>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Empleado empleado) {
        empleado.setBaja(true);
        entityManager.flush();
    }

    @Override
    public void darBajaAreaDeEmpleado(Empleado empleado, Area area) {
        entityManager.merge(empleado);
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

    @Override
    public List<Empleado> buscarPorFiltro(FiltroEmpleado filtroEmpleado) {
        Session session = entityManager.unwrap(Session.class);

        activarFiltros(filtroEmpleado, session);

        List<Empleado> empleados = buscar("");

        desactivarFiltros(session);

        if(filtroEmpleado.getTecnologias() != null){
            empleados = filtrarPorTecnologia(empleados, filtroEmpleado.getTecnologias());
        }

        return empleados;
    }

    @Override
    public void activarFiltros(FiltroEmpleado filtroEmpleado, Session session){
        if(filtroEmpleado.getLegajo() != null){
            session.enableFilter("filtroLegajo").setParameter("legajo",filtroEmpleado.getLegajo());
        }

        if(filtroEmpleado.getArea() != null){
            session.enableFilter("filtroArea").setParameter("idArea",filtroEmpleado.getArea().getId());
        }

        if(filtroEmpleado.getBaja() != null){
            session.enableFilter("filtroBaja").setParameter("baja",filtroEmpleado.getBaja());
        }

        if(filtroEmpleado.getNombres()!= null){
            session.enableFilter("filtroNombres").setParameter("nombres",filtroEmpleado.getNombres());
        }

        if(filtroEmpleado.getApellidos() != null){
            session.enableFilter("filtroApellidos").setParameter("apellidos",filtroEmpleado.getApellidos());
        }

        if(filtroEmpleado.getFechaIngreso() != null){
            session.enableFilter("filtroFechaIngreso").setParameter("fechaIngreso",filtroEmpleado.getFechaIngreso());
        }

        if(filtroEmpleado.getFechaEgreso() != null){
            session.enableFilter("filtroFechaEgreso").setParameter("fechaEgreso",filtroEmpleado.getFechaEgreso());
        }

        if(filtroEmpleado.getPromovidoLps() != null){
            session.enableFilter("filtroPromovido").setParameter("promovido",filtroEmpleado.getPromovidoLps());
        }
    }

    @Override
    public void desactivarFiltros(Session session){
        session.disableFilter("filtroLegajo");
        session.disableFilter("filtroArea");
        session.disableFilter("filtroBaja");
        session.disableFilter("filtroNombres");
        session.disableFilter("filtroApellidos");
        session.disableFilter("filtroFechaIngreso");
        session.disableFilter("filtroFechaEgreso");
        session.disableFilter("filtroPromovido");
    }

    @Override
    public List<Empleado> filtrarPorTecnologia(List<Empleado> empleados, List<Tecnologia> tecnologias) {
        List<Empleado> nuevaLista = new ArrayList<>();
        boolean tieneTecnologias = true;

        for (Empleado empleado : empleados) {
            tieneTecnologias = true;

            for(Tecnologia tecnologia : tecnologias){
                if(!empleado.getTecnologias().contains(tecnologia)){
                    tieneTecnologias = false;
                    break;
                }
            }
            if (tieneTecnologias){
                nuevaLista.add(empleado);
            }
        }

        return nuevaLista;
    }
}
