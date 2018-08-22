package ar.com.tecnosoftware.somos.empleado.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @PostMapping(value = "/crear")
    public void addEmpleado(@Valid @RequestBody Empleado empleado) {
        empleadoService.add(empleado);
    }

    @GetMapping (value = "/listar")
    public List<Empleado> findAllEmpleado() throws JRException {return empleadoService.buscarTodos();}

    @PutMapping (value = "/baja/{id}")
    public void bajaEmpleado(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectoEmpleados) {
        proyectoEmpleadoService.darBajaProyectosEmpleados(proyectoEmpleados);
        empleadoService.darBaja(id);
    }

}
