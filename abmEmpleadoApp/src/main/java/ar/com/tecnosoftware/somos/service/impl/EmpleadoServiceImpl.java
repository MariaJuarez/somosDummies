package ar.com.tecnosoftware.somos.service.impl;


import ar.com.tecnosoftware.somos.entity.Area;
import ar.com.tecnosoftware.somos.entity.Cargo;
import ar.com.tecnosoftware.somos.entity.Empleado;
import ar.com.tecnosoftware.somos.entity.Usuario;
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
    private CargoRepository cargoRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void add(Object entity) {
        Empleado empleado = (Empleado) entity;
        empleado.setCargo((Cargo) cargoRepository.buscar(empleado.getCargo().getIdCargoRhpro()));
        empleado.setArea((Area) areaRepository.buscar(empleado.getArea().getIdCentroCosto()));
        empleado.setUsuario((Usuario) usuarioRepository.buscar(empleado.getUsuario().getIdUsuario()));

        empleadoRepository.guardar(empleado);
    }

    @Override
    public Object buscar(int id) {
        return empleadoRepository.buscar(id);
    }

    @Override
    public List<Empleado> buscarTodos() {
        return empleadoRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        Empleado empleado = (Empleado) empleadoRepository.buscar(id);
        empleadoRepository.darBaja(empleado);
    }
}


