package ar.com.tecnosoftware.somos.proyecto.controller;

import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.filtro.FiltroProyecto;
import ar.com.tecnosoftware.somos.proyecto.exception.ProyectoErrorException;
import ar.com.tecnosoftware.somos.proyecto.exception.ProyectoNotFoundException;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @PostMapping(value = "/crear")
    public void addProyecto(@Valid @RequestBody Proyecto proyecto) throws ProyectoErrorException {

        String resultado = proyectoService.add(proyecto);
        if(!resultado.equals("")){
            throw new ProyectoErrorException(resultado);
        }
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Proyecto>> findProyectoActivos() throws ProyectoErrorException {
        List<Proyecto> proyectos = proyectoService.buscarNoBajas();
        if (proyectos == null) {
            throw new ProyectoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(proyectos);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Proyecto>> findAllProyecto() throws ProyectoErrorException {
        List<Proyecto> proyectos = proyectoService.buscarTodos();
        if (proyectos == null) {
            throw new ProyectoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(proyectos);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Proyecto> bajaProyecto(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectosEmpleados) throws ProyectoErrorException, ProyectoNotFoundException {

        Proyecto proyecto = proyectoService.darBaja(id);

        if (proyecto == null) {
            throw new ProyectoNotFoundException("No se encontró el proyecto con id " + id);
        }

        if (!proyectoEmpleadoService.darBajaProyectosEmpleados(proyectosEmpleados)) {
            throw new ProyectoErrorException("Hubo un error al dar de baja al proyecto por la relación con los ProyectoEmpleado");
        }

        return ResponseEntity.ok(proyecto);
    }

    @PostMapping(value = "/listarFiltro")
    public List<Proyecto> buscarProyectos(@RequestBody FiltroProyecto filtroProyecto) {
        if ((filtroProyecto != null) &&
                (filtroProyecto.getFechaInicio()) != null || (filtroProyecto.getFechaFin() != null) || (filtroProyecto.getCliente() != null)) {
            return proyectoService.buscarPorFiltro(filtroProyecto);
        }

        return proyectoService.buscarTodos();
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Proyecto> editarProyecto(@RequestBody Proyecto proyecto) throws ProyectoNotFoundException {
        Proyecto proyectoEditado = proyectoService.editar(proyecto);

        if (proyecto == null) {
            throw new ProyectoNotFoundException("No se encontró el proyecto con id " + proyecto.getId());
        }

        return ResponseEntity.ok(proyecto);

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
