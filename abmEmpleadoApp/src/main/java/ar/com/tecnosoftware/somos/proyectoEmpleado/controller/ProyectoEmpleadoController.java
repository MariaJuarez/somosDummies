package ar.com.tecnosoftware.somos.proyectoEmpleado.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.util.ProyectoEmpleadoFiltroUtil;
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

    @Autowired
    private ProyectoEmpleadoFiltroUtil proyectoEmpleadoFiltroUtil;

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

    @PostMapping (value = "/filtrarEmpleados")
    public List<Empleado> buscarEmpleadosPorFiltro(@RequestBody FiltroEmpleado filtroEmpleado){

        List<Empleado> filtroPorEmpleado = null;
        List<Empleado> filtroPorProyecto = null;

        if((filtroEmpleado != null) &&
                (filtroEmpleado.getLegajo()) != null || (filtroEmpleado.getArea() != null) || (filtroEmpleado.getBaja() != null) || (filtroEmpleado.getNombres() != null) ||
                (filtroEmpleado.getApellidos() != null) || (filtroEmpleado.getFechaIngreso() != null) || (filtroEmpleado.getFechaEgreso() != null) || (filtroEmpleado.getPromovidoLps() != null) ||
                (filtroEmpleado.getTecnologias() != null)){
            filtroPorEmpleado = empleadoService.buscarPorFiltro(filtroEmpleado);
        }

        if((filtroEmpleado != null) &&
                (filtroEmpleado.getRubro() != null) || (filtroEmpleado.getTipoProyecto() != null) || (filtroEmpleado.getClientes() != null) || (filtroEmpleado.getProyecto()!= null)){
            filtroPorProyecto = proyectoEmpleadoService.buscarEmpleadosPorFiltro(filtroEmpleado);
        }

        if(filtroPorEmpleado != null && filtroPorProyecto != null){
            return proyectoEmpleadoFiltroUtil.filtroPorEmpleadoPorProyecto(filtroPorEmpleado,filtroPorProyecto);
        } else {
            if(filtroPorEmpleado != null){
                return filtroPorEmpleado;
            } else {
                if(filtroPorProyecto != null){
                    return filtroPorProyecto;
                }
            }
        }

        return empleadoService.buscarTodos();
    }

    @PutMapping(value = "/editar")
    public void editarProyectoEmpleado(@RequestBody ProyectoEmpleado proyectoEmpleado){
        proyectoEmpleadoService.editar(proyectoEmpleado);
    }

}
