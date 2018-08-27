package ar.com.tecnosoftware.somos.proyectoEmpleado.controller;

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
@RequestMapping("/proyectoEmpleado")
public class ProyectoEmpleadoController {

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping(value = "/crear")
    public void addProyectoEmpleado(@Valid @RequestBody ProyectoEmpleado proyectoEmpleado) {
        proyectoEmpleadoService.add(proyectoEmpleado);
    }

    @GetMapping (value = "/listarActivos")
    public List<ProyectoEmpleado> findProyectoEmpleadoActivos(){
        return proyectoEmpleadoService.buscarNoBajas();
    }

    @GetMapping (value = "/listarTodos")
    public List<ProyectoEmpleado> findAllProyectoEmpleado(){
        return proyectoEmpleadoService.buscarTodos();
    }

    @PutMapping (value = "/baja/{id}")
    public void bajaProyectoEmpleado(@PathVariable int id) {
        proyectoEmpleadoService.darBaja(id);
    }

    //Los atributos deben venir con los objetos completos para realizar bien el filtro.
    @PostMapping (value = "/filtrarEmpleados")
    public List<Empleado> buscarEmpleadosPorFiltro(@RequestBody FiltroEmpleado filtroEmpleado){

        if((filtroEmpleado != null) &&
                (filtroEmpleado.getRubro() != null) || (filtroEmpleado.getTipoProyecto() != null) || (filtroEmpleado.getClientes() != null) || (filtroEmpleado.getProyecto()!= null)){
            return proyectoEmpleadoService.buscarEmpleadosPorFiltro(filtroEmpleado);
        }

        return empleadoService.buscarTodos();
    }

}
