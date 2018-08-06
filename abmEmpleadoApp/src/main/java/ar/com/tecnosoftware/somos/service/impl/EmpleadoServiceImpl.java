package ar.com.tecnosoftware.somos.service.impl;


import ar.com.tecnosoftware.somos.entity.Empleado;
import ar.com.tecnosoftware.somos.repository.*;
import ar.com.tecnosoftware.somos.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void addEmpleado(Empleado empleado) {
        empleado.setClienteActual(clienteRepository.buscar(empleado.getClienteActual().getIdCliente()));
        empleado.setCargo(cargoRepository.buscar(empleado.getCargo().getIdCargoRhpro()));
        empleado.setArea(areaRepository.buscar(empleado.getArea().getIdCentroCosto()));
        empleado.setUsuario(usuarioRepository.buscar(empleado.getUsuario().getIdUsuario()));

        empleadoRepository.guardar(empleado);
    }

    @Override
    public List<Empleado> buscarTodos() {
        return empleadoRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        Empleado empleado = empleadoRepository.buscar(id);
        empleadoRepository.darBaja(empleado);
    }
}


