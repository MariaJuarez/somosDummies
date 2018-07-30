package ar.com.tecnosoftware.somos.empleados.service.impl;

import ar.com.tecnosoftware.somos.empleados.entity.Empleado;

import ar.com.tecnosoftware.somos.empleados.repository.EmpleadoRepository;
import ar.com.tecnosoftware.somos.empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    /*
        @Override
        public List<Empleado> listEmpleados() {
            return empleadoRepository.findAll();
        }
    */
    @Override
    public void addEmpleado(Empleado empleado) {
        empleadoRepository.guardar(empleado);
    }
/*
    @Override
    public boolean deleteEmpleado(int empleadoId) {
        if (empleadoRepository.findOne(empleadoId) == null) {
            return false;
        }
        empleadoRepository.delete(empleadoId);
        return true;
    }

    @Override
    public boolean editEmpleado(int empleadoId, Empleado empleadoEdited) {
        if (empleadoRepository.findOne(empleadoId) == null) {
            return false;
        }
        empleadoEdited.setId(empleadoId);
        empleadoRepository.save(empleadoEdited);
        return true;
    }

    @Override
    public Empleado searchEmpleado(int empleadoId) {
        return empleadoRepository.findOne(empleadoId);
    }
*/
}


