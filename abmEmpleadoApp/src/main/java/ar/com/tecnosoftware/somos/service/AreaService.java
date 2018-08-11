package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entity.Area;

import java.util.List;

public interface AreaService {

    public void addArea(Area area);

    public List<Area> buscarTodos();

    public void darBaja(int id);

}
