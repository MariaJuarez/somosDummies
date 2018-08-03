package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entityoOld.CentroCosto;

import java.util.List;

public interface CentroCostoRepository {

    public void guardar(CentroCosto centroCosto);

    public CentroCosto buscar(CentroCosto centroCosto);

    public List<CentroCosto> buscarTodos();

    public void darBaja(CentroCosto centroCosto);

}
