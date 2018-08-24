package ar.com.tecnosoftware.somos.empleado.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
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

    @GetMapping (value = "/listarActivos")
    public List<Empleado> findEmpleadoActivos() {return empleadoService.buscarNoBajas();}

    @GetMapping (value = "/listarTodos")
    public List<Empleado> findAllEmpleado() {return empleadoService.buscarTodos();}

    @PutMapping (value = "/baja/{id}")
    public void bajaEmpleado(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectoEmpleados) {
        proyectoEmpleadoService.darBajaProyectosEmpleados(proyectoEmpleados);
        empleadoService.darBaja(id);
    }

    @PostMapping(value = "/listarFiltro")
    public List<Empleado> buscarEmpleados(@RequestBody FiltroEmpleado filtroEmpleado){
        if((filtroEmpleado != null) &&
                (filtroEmpleado.getLegajo()) != null || (filtroEmpleado.getArea() != null) || (filtroEmpleado.getBaja() != null) || (filtroEmpleado.getNombres() != null) ||
                (filtroEmpleado.getApellidos() != null) || (filtroEmpleado.getFechaIngreso() != null) || (filtroEmpleado.getFechaEgreso() != null) || (filtroEmpleado.getPromovidoLps() != null) ||
                (filtroEmpleado.getTecnologias() != null)){
            return empleadoService.buscarPorFiltro(filtroEmpleado);
        }

        return empleadoService.buscarTodos();
    }

}
