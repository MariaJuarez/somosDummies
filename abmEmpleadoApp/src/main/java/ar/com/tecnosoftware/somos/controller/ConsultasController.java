package ar.com.tecnosoftware.somos.controller;

import ar.com.tecnosoftware.somos.entity.Empleado;
import ar.com.tecnosoftware.somos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/consulta")
public class ConsultasController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/empleadosConArea/{id}")
    public List<Empleado> buscarEmpleadosConArea(@PathVariable int id) {
        return empleadoService.buscarEmpleadosConArea(id);
    }

}
