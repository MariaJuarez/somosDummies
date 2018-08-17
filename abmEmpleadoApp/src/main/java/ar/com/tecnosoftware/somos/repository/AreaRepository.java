package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Area;

import java.util.List;

public interface AreaRepository {

    public void guardar(Area area);

    public Area buscar(int id);

    public List<Area> buscarTodos();

    public void darBaja(Area area);

}
