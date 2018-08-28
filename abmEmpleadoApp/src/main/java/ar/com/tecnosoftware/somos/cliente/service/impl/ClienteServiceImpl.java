package ar.com.tecnosoftware.somos.cliente.service.impl;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import ar.com.tecnosoftware.somos.cliente.repository.ClienteRepository;
import ar.com.tecnosoftware.somos.rubro.repository.RubroRepository;
import ar.com.tecnosoftware.somos.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RubroRepository rubroRepository;

    @Override
    public void add(Cliente cliente) {
        cliente.setRubro(rubroRepository.buscar(cliente.getRubro().getId()));
        clienteRepository.guardar(cliente);
    }

    @Override
    public Cliente buscar(int id) {
        return clienteRepository.buscar(id);
    }

    @Override
    public List<Cliente> buscarNoBajas() {
        return clienteRepository.buscar("WHERE baja = false");
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.buscar("");
    }

    @Override
    public void darBaja(int id) {
        clienteRepository.darBaja(clienteRepository.buscar(id));
    }

    @Override
    public List<Cliente> buscarClientesConRubro(int idRubro) {
        return clienteRepository.buscar("WHERE rubro = " +idRubro);
    }

    @Override
    public void darBajaRubroDeClientes(List<Cliente> clientes) {
        Rubro rubro = rubroRepository.buscar(1);
        for(Cliente cliente : clientes){
            clienteRepository.darBajaRubroDeCliente(cliente, rubro);
        }
    }

    @Override
    public void editar(Cliente cliente) {
        if (clienteRepository.buscar(cliente.getId()) == null){
            return;
        }
        clienteRepository.editar(cliente);
    }
}
