package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entityoOld.Cliente;

import java.util.List;

public interface ClienteRepository {

    public void guardar(Cliente cliente);

    public Cliente buscar(Cliente cliente);

    public List<Cliente> buscarTodos();

    public void darBaja(Cliente cliente);

}
