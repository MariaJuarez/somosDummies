package ar.com.tecnosoftware.somos.tecnologia.repository.impl;

import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;
import ar.com.tecnosoftware.somos.tecnologia.repository.TecnologiaRepository;
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
    public List<Tecnologia> buscar(String extension) {
        String hql = "FROM Tecnologia " + extension;
        return (List<Tecnologia>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Tecnologia tecnologia) {
        tecnologia.setBaja(true);
        entityManager.flush();
    }

    @Override
    public void darBajaTipoTecnologiaDeTecnologia(Tecnologia tecnologia, TipoTecnologia tipoTecnologia) {
        tecnologia.setTipo(tipoTecnologia);
        entityManager.merge(tecnologia);
    }
}
