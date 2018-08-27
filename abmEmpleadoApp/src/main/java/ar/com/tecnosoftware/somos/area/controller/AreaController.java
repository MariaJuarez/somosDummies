package ar.com.tecnosoftware.somos.area.controller;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.area.service.AreaService;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping(value = "/crear")
    public void addArea(@Valid @RequestBody Area area) {
        areaService.add(area);
    }

    @GetMapping (value = "/listarActivos")
    public List<Area> findAreasActivas(){
        return areaService.buscarNoBajas();
    }

    @GetMapping (value = "/listarTodos")
    public List<Area> findAllArea(){
        return areaService.buscarTodos();
    }

    @PutMapping (value = "/baja/{id}")
    public void bajaArea(@PathVariable int id, @RequestBody List<Empleado> empleados) {
        empleadoService.darBajaAreaDeEmpleados(empleados);
        areaService.darBaja(id);
    }

}
