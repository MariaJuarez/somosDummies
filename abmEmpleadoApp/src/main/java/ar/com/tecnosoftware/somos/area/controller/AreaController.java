package ar.com.tecnosoftware.somos.area.controller;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.area.exception.AreaErrorException;
import ar.com.tecnosoftware.somos.area.exception.AreaNotFoundException;
import ar.com.tecnosoftware.somos.area.service.AreaService;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping(value = "/crear")
    public void addArea(@RequestBody Area area) {
        areaService.add(area);
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Area>> findAreasActivas() throws AreaErrorException {
        List<Area> areas = areaService.buscarNoBajas();
        if (areas == null) {
            throw new AreaErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(areas);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Area>> findAllArea() throws AreaErrorException {

        List<Area> areas = areaService.buscarTodos();
        if (areas == null) {
            throw new AreaErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(areas);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Area> bajaArea(@PathVariable int id, @RequestBody List<Empleado> empleados) throws AreaErrorException, AreaNotFoundException {
        Area area = areaService.darBaja(id);

        if (area == null) {
            throw new AreaNotFoundException("No se encontró el area con id " + id);
        }

        if (!empleadoService.darBajaAreaDeEmpleados(empleados)) {
            throw new AreaErrorException("Hubo un error al dar de baja al area por la relación con los empleados. Puede que no exista el Area por defecto.");
        }

        return ResponseEntity.ok(area);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Area> editarArea(@RequestBody Area area) throws AreaNotFoundException {
        Area editado = areaService.editar(area);
        if (editado == null) {
            throw new AreaNotFoundException("No se encontró el area con id " + area.getId());
        }
        return ResponseEntity.ok(editado);
    }

    @ExceptionHandler(AreaNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(AreaNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(AreaErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(AreaErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

}
