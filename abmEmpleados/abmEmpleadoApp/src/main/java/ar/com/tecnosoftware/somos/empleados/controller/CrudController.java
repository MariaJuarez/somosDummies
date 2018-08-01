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
import java.util.List;
import java.util.Map;

/**

 * Clase controladora la cual recibe peticiones desde la WEB y da entrada a los metodos de ABM

 * TODO @author: Maria J. Juarez P.

 * @version: 25/07/2018/A

 */


@RestController
@CrossOrigin
@RequestMapping("/crud")
public class CrudController {

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

    @PostMapping (value = "/crear/empleado")
    public void addEmpleado(@Valid @RequestBody Empleado empleado) {
        empleadoService.addEmpleado(empleado);
    }

    @PostMapping (value = "/crear/cliente")
    public void addCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
    }

    @PostMapping (value = "/crear/cargoRHPRO")
    public void addCargpRHPRO(@Valid @RequestBody CargoRHPRO cargoRHPRO) {
        cargoRHPROService.addCargoRHPRO(cargoRHPRO);
    }

    @PostMapping (value = "/crear/centroCosto")
    public void addCentroCosto(@Valid @RequestBody CentroCosto centroCosto) {
        centroCostoService.addCentroCosto(centroCosto);
    }

    @PostMapping (value = "/crear/usuario")
    public void addUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.addUsuario(usuario);
    }

    @GetMapping (value = "/list/empleado")
    public List<Empleado> findAllEmpleado(){ return empleadoService.buscarTodos();}

    @GetMapping (value = "/list/cliente")
    public List<Cliente> findAllCliente(){ return clienteService.buscarTodos();}

    @GetMapping (value = "/list/cargoRHPRO")
    public List<CargoRHPRO> findAllCargoRHPRO(){ return cargoRHPROService.buscarTodos();}

    @GetMapping (value = "/list/centroCosto")
    public List<CentroCosto> findAllCentroCosto(){ return centroCostoService.buscarTodos();}

    @GetMapping (value = "/list/usuario")
    public List<Usuario> findAllUsuario(){ return usuarioService.buscarTodos();}

    @DeleteMapping (value = "/baja/empleado")
    public void bajaEmpleado(@Valid @RequestBody Empleado empleado) {
        empleadoService.darBaja(empleado);
    }

    @DeleteMapping (value = "/baja/cliente")
    public void bajaCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.darBaja(cliente);
    }

    @DeleteMapping (value = "/baja/cargoRHPRO")
    public void bajaCargpRHPRO(@Valid @RequestBody CargoRHPRO cargoRHPRO) {
        cargoRHPROService.darBaja(cargoRHPRO);
    }

    @DeleteMapping (value = "/baja/centroCosto")
    public void bajaCentroCosto(@Valid @RequestBody CentroCosto centroCosto) {
        centroCostoService.darBaja(centroCosto);
    }

    @DeleteMapping (value = "/baja/usuario")
    public void bajaUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.darBaja(usuario);
    }

    @ExceptionHandler(EmpleadoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> onException(EmpleadoNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

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