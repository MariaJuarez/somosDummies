package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entityoOld.CentroCosto;

import java.util.List;

public interface CentroCostoService {

    public void addCentroCosto(CentroCosto centroCosto);

    public List<CentroCosto> buscarTodos();

    public void darBaja(CentroCosto centroCosto);

}
