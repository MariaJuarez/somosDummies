package ar.com.tecnosoftware.somos.empleados.controller;
import ar.com.tecnosoftware.somos.empleados.entity.*;
import ar.com.tecnosoftware.somos.empleados.exception.EmpleadoNotFoundException;
import ar.com.tecnosoftware.somos.empleados.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**

 * Controler CRUD

 * @version: 25/07/2018/A

 */


@RestController
@CrossOrigin
@RequestMapping("/crud")
public class PrimerController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CargoRHPROService cargoRHPROService;

    @Autowired
    private CentroCostoService centroCostoService;

    @Autowired
    private UsuarioService usuarioService;

    /**
     *
     * @param empleado
     */
    @PostMapping (value = "/crear/empleado")
    public void addEmpleado(@Valid @RequestBody Empleado empleado) {
        empleadoService.addEmpleado(empleado);
    }

    /**
     *
     * @param cliente
     */
    @PostMapping (value = "/crear/cliente")
    public void addCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
    }

    /**
     *
     * @param cargoRHPRO
     */
    @PostMapping (value = "/crear/cargoRHPRO")
    public void addCargpRHPRO(@Valid @RequestBody CargoRHPRO cargoRHPRO) {
        cargoRHPROService.addCargoRHPRO(cargoRHPRO);
    }

    /**
     *
     * @param centroCosto
     */
    @PostMapping (value = "/crear/centroCosto")
    public void addCentroCosto(@Valid @RequestBody CentroCosto centroCosto) {
        centroCostoService.addCentroCosto(centroCosto);
    }

    /**
     *
     * @param usuario
     */
    @PostMapping (value = "/crear/usuario")
    public void addUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.addUsuario(usuario);
    }

    /**
     *
     * @param e
     * @return mensaje si no existe el empleado
     */
    @ExceptionHandler(EmpleadoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> onException(EmpleadoNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    /**
     *
     * @param ex
     * @return Excepción que se lanzará cuando la validación de un argumento anotado con
     * {@code @Valid} falla.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Map<String, String>> validationError(MethodArgumentNotValidException ex) {
        Map<String, String> map = new HashMap<>();
        Map<String, Map<String, String>> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        errors.put("errores", map);
        return errors;
    }

    /**
     *
     * @param ex
     * @return Lanzado cuando los errores de enlace se consideran fatales. Implementa el
     * BindingResult interfaz (y su super-interfaz Errors)
     * para permitir el análisis directo de errores vinculantes.
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Map<String, String>> validationError(BindException ex) {
        Map<String, String> map = new HashMap<>();
        Map<String, Map<String, String>> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        errors.put("errores", map);
        return errors;
    }


}