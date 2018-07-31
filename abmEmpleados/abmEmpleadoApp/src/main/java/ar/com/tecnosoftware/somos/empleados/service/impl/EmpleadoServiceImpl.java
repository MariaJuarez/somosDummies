package ar.com.tecnosoftware.somos.empleados.service.impl;

import ar.com.tecnosoftware.somos.empleados.entity.Empleado;

import ar.com.tecnosoftware.somos.empleados.repository.*;
import ar.com.tecnosoftware.somos.empleados.service.EmpleadoService;
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
    private CargoRHPRORepository cargoRHPRORepository;

    @Autowired
    private CentroCostoRepository centroCostoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void addEmpleado(Empleado empleado) {
        empleado.setCliente_actual(clienteRepository.buscar(empleado.getCliente_actual()));
        empleado.setCargo(cargoRHPRORepository.buscar(empleado.getCargo()));
        empleado.setCentro_costo(centroCostoRepository.buscar(empleado.getCentro_costo()));
        empleado.setUsuario(usuarioRepository.buscar(empleado.getUsuario()));

        empleadoRepository.guardar(empleado);
    }

    @Override
    public List<Empleado> buscarTodos() {
        return empleadoRepository.buscarTodos();
    }

    @Override
    public void darBaja(Empleado empleado) {
        empleadoRepository.darBaja(empleadoRepository.buscar(empleado));
    }
}


