package ar.com.tecnosoftware.somos.proyectoEmpleado.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.proyecto.exception.ProyectoErrorException;
import ar.com.tecnosoftware.somos.proyecto.exception.ProyectoNotFoundException;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.exception.ProyectoEmpleadoErrorException;
import ar.com.tecnosoftware.somos.proyectoEmpleado.exception.ProyectoEmpleadoNotFoundException;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.util.ProyectoEmpleadoFiltroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
    public void addProyectoEmpleado(@Valid @RequestBody ProyectoEmpleado proyectoEmpleado) throws ProyectoEmpleadoErrorException {
        String resultado = proyectoEmpleadoService.add(proyectoEmpleado);
        if (!resultado.equals("")) {
            throw new ProyectoEmpleadoErrorException(resultado);
        }
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<ProyectoEmpleado>> findProyectoEmpleadoActivos() throws ProyectoEmpleadoErrorException {
        List<ProyectoEmpleado> proyectoEmpleados = proyectoEmpleadoService.buscarNoBajas();
        if (proyectoEmpleados == null) {
            throw new ProyectoEmpleadoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(proyectoEmpleados);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<ProyectoEmpleado>> findAllProyectoEmpleado() throws ProyectoEmpleadoErrorException {
        List<ProyectoEmpleado> proyectoEmpleados = proyectoEmpleadoService.buscarTodos();
        if (proyectoEmpleados == null) {
            throw new ProyectoEmpleadoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(proyectoEmpleados);
    }

    @PutMapping(value = "/baja/{id}")
    public ResponseEntity<ProyectoEmpleado> bajaProyectoEmpleado(@PathVariable int id) throws ProyectoEmpleadoNotFoundException {
        ProyectoEmpleado proyectoEmpleado = proyectoEmpleadoService.darBaja(id);

        if (proyectoEmpleado == null) {
            throw new ProyectoEmpleadoNotFoundException("No se encontró el proyecto-empleado con id " + id);
        }

        return ResponseEntity.ok(proyectoEmpleado);
    }

    @PostMapping(value = "/filtrarEmpleados")
    public List<Empleado> buscarEmpleadosPorFiltro(@RequestBody FiltroEmpleado filtroEmpleado) {

        List<Empleado> filtroPorEmpleado = null;
        List<Empleado> filtroPorProyecto = null;

        if ((filtroEmpleado != null) &&
                (filtroEmpleado.getLegajo()) != null || (filtroEmpleado.getArea() != null) || (filtroEmpleado.getBaja() != null) || (filtroEmpleado.getNombres() != null) ||
                (filtroEmpleado.getApellidos() != null) || (filtroEmpleado.getFechaIngreso() != null) || (filtroEmpleado.getFechaEgreso() != null) || (filtroEmpleado.getPromovidoLps() != null) ||
                (filtroEmpleado.getTecnologias() != null)) {
            filtroPorEmpleado = empleadoService.buscarPorFiltro(filtroEmpleado);
        }

        if ((filtroEmpleado != null) &&
                (filtroEmpleado.getRubro() != null) || (filtroEmpleado.getTipoProyecto() != null) || (filtroEmpleado.getClientes() != null) || (filtroEmpleado.getProyecto() != null)) {
            filtroPorProyecto = proyectoEmpleadoService.buscarEmpleadosPorFiltro(filtroEmpleado);
        }

        if (filtroPorEmpleado != null && filtroPorProyecto != null) {
            return proyectoEmpleadoFiltroUtil.filtroPorEmpleadoPorProyecto(filtroPorEmpleado, filtroPorProyecto);
        } else {
            if (filtroPorEmpleado != null) {
                return filtroPorEmpleado;
            } else {
                if (filtroPorProyecto != null) {
                    return filtroPorProyecto;
                }
            }
        }

        return empleadoService.buscarTodos();
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<ProyectoEmpleado> editarProyectoEmpleado(@RequestBody ProyectoEmpleado proyectoEmpleado) throws ProyectoEmpleadoNotFoundException {
        ProyectoEmpleado editado = proyectoEmpleadoService.editar(proyectoEmpleado);
        if (editado == null) {
            throw new ProyectoEmpleadoNotFoundException("No se encontró el area con id " + proyectoEmpleado.getId());
        }
        return ResponseEntity.ok(editado);
    }

    @ExceptionHandler(ProyectoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(ProyectoNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(ProyectoErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(ProyectoErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

}
