package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.entity.Area;
import ar.com.tecnosoftware.somos.repository.AreaRepository;
import ar.com.tecnosoftware.somos.service.AreaService;
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
    public void addArea(Area area) {
        areaRepository.guardar(area);
    }

    @Override
    public List<Area> buscarTodos() {
        return areaRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        Area area = areaRepository.buscar(id);
        areaRepository.darBaja(area);
    }
}
