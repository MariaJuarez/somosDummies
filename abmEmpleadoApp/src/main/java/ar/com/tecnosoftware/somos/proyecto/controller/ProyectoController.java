package ar.com.tecnosoftware.somos.proyecto.controller;

import ar.com.tecnosoftware.somos.cliente.service.ClienteService;
import ar.com.tecnosoftware.somos.metodologia.service.MetodologiaService;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.filtro.FiltroProyecto;
import ar.com.tecnosoftware.somos.proyecto.exception.ProyectoErrorException;
import ar.com.tecnosoftware.somos.proyecto.exception.ProyectoNotFoundException;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import ar.com.tecnosoftware.somos.tipoProyecto.service.TipoProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
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

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MetodologiaService metodologiaService;

    @Autowired
    private TipoProyectoService tipoProyectoService;

    @PostMapping(value = "/crear")
    public String addProyecto(@Valid @RequestBody Proyecto proyecto) throws ProyectoErrorException {

        String resultado = proyectoService.add(proyecto);
        if (!resultado.equals("")) {
            throw new ProyectoErrorException(resultado);
        }
        return resultado;
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
    public ResponseEntity<Proyecto> editarProyecto(@Valid @RequestBody Proyecto proyecto) throws ProyectoNotFoundException, ProyectoErrorException {

        if (clienteService.buscar(proyecto.getCliente().getId()) == null) {
            throw new ProyectoErrorException("No existe el cliente con id " + proyecto.getCliente().getId());
        }

        if (metodologiaService.buscar(proyecto.getMetodologia().getId()) == null) {
            throw new ProyectoErrorException("No existe la metodologia con id " + proyecto.getMetodologia().getId());
        }

        if (tipoProyectoService.buscar(proyecto.getTipo().getId()) == null) {
            throw new ProyectoErrorException("No existe el tipo de proyecto con id " + proyecto.getTipo().getId());
        }

        Proyecto proyectoEditado = proyectoService.editar(proyecto);

        if (proyecto == null) {
            throw new ProyectoNotFoundException("No se encontró el proyecto con id " + proyecto.getId());
        }

        return ResponseEntity.ok(proyectoEditado);

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Map<String, String>> errorException(MethodArgumentNotValidException e) {
        Map<String, String> map = new HashMap<>();
        Map<String, Map<String, String>> errors = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        errors.put("errores", map);
        return errors;
    }

}
