package ar.com.tecnosoftware.somos.area.service.impl;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.area.repository.AreaRepository;
import ar.com.tecnosoftware.somos.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public void add(Area area) {
        areaRepository.guardar(area);
    }

    @Override
    public Area buscar(int id) {
        return areaRepository.buscar(id);
    }

    @Override
    public List<Area> buscarTodos() {
        return areaRepository.buscar("");
    }

    @Override
    public List<Area> buscarNoBajas() {
        return areaRepository.buscar("WHERE baja = false");
    }

    @Override
    public void darBaja(int id) {
        areaRepository.darBaja(areaRepository.buscar(id));
    }
}
