package ar.com.tecnosoftware.somos.cliente.service;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.service.Service;

import java.util.List;

public interface ClienteService extends Service<Cliente> {

    List<Cliente> buscarClientesConRubro(int idRubro);

    Boolean darBajaRubroDeClientes(List<Cliente> clientes);

}
