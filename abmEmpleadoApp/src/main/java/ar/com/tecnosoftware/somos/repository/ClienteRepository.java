package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Cliente;
import ar.com.tecnosoftware.somos.entity.Rubro;

import java.util.List;

public interface ClienteRepository extends Repository<Cliente> {

    List<Cliente> buscarClientesConRubro(int idRubro);

    void darBajaRubroDeCliente(Cliente cliente, Rubro rubro);

}
