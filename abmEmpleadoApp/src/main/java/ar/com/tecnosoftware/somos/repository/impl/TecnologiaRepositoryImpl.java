package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.Tecnologia;
import ar.com.tecnosoftware.somos.entity.TipoTecnologia;
import ar.com.tecnosoftware.somos.repository.TecnologiaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TecnologiaRepositoryImpl implements TecnologiaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Tecnologia tecnologia) {
        entityManager.persist(tecnologia);
    }

    @Override
    public Tecnologia buscar(int id) {
        return entityManager.find(Tecnologia.class, id);
    }

    @Override
    public List<Tecnologia> buscarTodos() {
        String hql = "FROM Tecnologia WHERE baja = false";
        return (List<Tecnologia>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Tecnologia tecnologia) {
        tecnologia.setBaja(true);
        entityManager.flush();
    }

    @Override
    public List<Tecnologia> buscarTecnologiasConTipoTecnologia(int idTipoTecnologia) {
        String hql = "FROM Tecnologia WHERE tipoTecnologia = " + idTipoTecnologia;
        return (List<Tecnologia>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBajaTipoTecnologiaDeTecnologia(Tecnologia tecnologia, TipoTecnologia tipoTecnologia) {
        tecnologia.setTipoTecnologia(tipoTecnologia);
        entityManager.merge(tecnologia);
    }
}
