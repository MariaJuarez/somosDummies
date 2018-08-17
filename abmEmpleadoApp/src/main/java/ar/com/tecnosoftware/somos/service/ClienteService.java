package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entity.Cliente;

import java.util.List;

public interface ClienteService extends Service<Cliente> {

    List<Cliente> buscarClientesConRubro(int idRubro);

    void darBajaRubroDeClientes(List<Cliente> clientes);

}
