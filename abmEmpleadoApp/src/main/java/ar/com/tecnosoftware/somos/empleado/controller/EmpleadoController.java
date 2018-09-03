package ar.com.tecnosoftware.somos.empleado.controller;

import ar.com.tecnosoftware.somos.area.service.AreaService;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.exception.EmpleadoErrorException;
import ar.com.tecnosoftware.somos.empleado.exception.EmpleadoNotFoundException;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.perfil.service.PerfilService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import ar.com.tecnosoftware.somos.usuario.entity.Usuario;
import ar.com.tecnosoftware.somos.usuario.service.UsuarioService;
import ar.com.tecnosoftware.somos.util.FechasUtil;
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
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private PerfilService perfilService;

    @PostMapping(value = "/crear")
    public String addEmpleado(@Valid @RequestBody Empleado empleado) throws EmpleadoErrorException {

        String resultado = empleadoService.add(empleado);

        if (!resultado.equals("Empleado creado con exito")) {
            throw new EmpleadoErrorException(resultado);
        }

        return resultado;
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Empleado>> findEmpleadoActivos() throws EmpleadoErrorException {
        List<Empleado> empleados = empleadoService.buscarNoBajas();
        if (empleados == null) {
            throw new EmpleadoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(empleados);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Empleado>> findAllEmpleado() throws EmpleadoErrorException {
        List<Empleado> empleados = empleadoService.buscarTodos();
        if (empleados == null) {
            throw new EmpleadoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(empleados);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Empleado> bajaEmpleado(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectoEmpleados, @RequestBody Usuario usuario) throws EmpleadoErrorException, EmpleadoNotFoundException {
        Empleado empleado = empleadoService.darBaja(id);
        if (empleado == null) {
            throw new EmpleadoNotFoundException("No se encontró el empleado con id " + id);
        }

        if (!proyectoEmpleadoService.darBajaProyectosEmpleados(proyectoEmpleados)) {
            throw new EmpleadoErrorException("Hubo un error al dar de baja al empleado por la relación con los ProyectoEmpleados");
        }

        if ((usuario != null) && !usuarioService.darBajaEmpleadoDeUsuario(usuario)) {
            throw new EmpleadoErrorException("Hubo un error al dar de baja al empleado por la relación con los usuarios. Puede que no exista el Empleado por defecto");
        }

        return ResponseEntity.ok(empleado);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Empleado> editarEmpleado(@Valid @RequestBody Empleado empleado) throws EmpleadoNotFoundException, EmpleadoErrorException {

        if (areaService.buscar(empleado.getArea().getId()) == null) {
            throw new EmpleadoErrorException("No existe el area con id " + empleado.getArea().getId());
        }

        if (perfilService.buscar(empleado.getPerfil().getId()) == null) {
            throw new EmpleadoErrorException("No existe el perfil con id " + empleado.getPerfil().getId());
        }

        if(!FechasUtil.comprobarFechas(empleado.getIngreso(), empleado.getEgreso())){
            throw new EmpleadoErrorException("La fecha de egreso no puede ser anterior a la fecha de ingreso");
        }

        Empleado empleadoEditado = empleadoService.editar(empleado);

        if (empleadoEditado == null) {
            throw new EmpleadoNotFoundException("No se encontró el empleado con id " + empleado.getId());
        }

        return ResponseEntity.ok(empleadoEditado);
    }

    @ExceptionHandler(EmpleadoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(EmpleadoNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(EmpleadoErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(EmpleadoErrorException e) {
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
