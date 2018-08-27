package ar.com.tecnosoftware.somos.controller;

import ar.com.tecnosoftware.somos.cliente.service.ClienteService;
import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tecnologia.service.TecnologiaService;
import ar.com.tecnosoftware.somos.usuario.entity.Usuario;
import ar.com.tecnosoftware.somos.usuario.service.UsuarioService;
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
    private UsuarioService usuarioService;

    @Autowired
    private TecnologiaService tecnologiaService;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @GetMapping(value = "/empleadosConArea/{id}")
    public List<Empleado> buscarEmpleadosConArea(@PathVariable int id) {
        return empleadoService.buscarEmpleadosConArea(id);
    }

    @GetMapping(value = "/empleadosConPerfil/{id}")
    public List<Empleado> buscarEmpleadosConPerfil(@PathVariable int id) {
        return empleadoService.buscarEmpleadosConPerfil(id);
    }

    @GetMapping(value = "/empleadosConTecnologia/{id}")
    public List<Empleado> buscarEmpleadosConTecnologia(@PathVariable int id) {
        return empleadoService.buscarEmpleadosConTecnologia(id);
    }

    @GetMapping(value = "/usuarioConEmpleado/{id}")
    public Usuario buscarUsuarioConEmpleado(@PathVariable int id) {
        return usuarioService.buscarUsuarioConEmpleado(id);
    }

    @GetMapping(value = "/tecnologiasConTipoTecnologia/{id}")
    public List<Tecnologia> buscarTecnologiasConTipoTecnologia(@PathVariable int id) {
        return tecnologiaService.buscarTecnologiasConTipoTecnologia(id);
    }

    @GetMapping(value = "/clientesConRubro/{id}")
    public List<Cliente> buscarClientesConRubro(@PathVariable int id) {
        return clienteService.buscarClientesConRubro(id);
    }

    @GetMapping(value = "/proyectosConCliente/{id}")
    public List<Proyecto> buscarProyectosConCliente(@PathVariable int id) {
        return proyectoService.buscarProyectosConCliente(id);
    }

    @GetMapping(value = "/proyectosConMetodologia/{id}")
    public List<Proyecto> buscarProyectosConMetodologia(@PathVariable int id) {
        return proyectoService.buscarProyectosConMetodologia(id);
    }

    @GetMapping(value = "/proyectosConTipoProyecto/{id}")
    public List<Proyecto> buscarProyectosConTipoProyecto(@PathVariable int id) {
        return proyectoService.buscarProyectosConTipoProyecto(id);
    }

    @GetMapping(value = "/proyectosConTecnologia/{id}")
    public List<Proyecto> buscarProyectosConTecnologia(@PathVariable int id) {
        return proyectoService.buscarProyectosConTecnologia(id);
    }

    @GetMapping(value = "/proyectosEmpleadosConEmpleado/{id}")
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConEmpleado(@PathVariable int id) {
        return proyectoEmpleadoService.buscarProyectosEmpleadosConEmpleado(id);
    }

    @GetMapping(value = "/proyectosEmpleadosConProyecto/{id}")
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConProyecto(@PathVariable int id) {
        return proyectoEmpleadoService.buscarProyectosEmpleadosConProyecto(id);
    }

    @GetMapping(value = "/proyectosEmpleadosConCargo/{id}")
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConCargo(@PathVariable int id) {
        return proyectoEmpleadoService.buscarProyectosEmpleadosConCargo(id);
    }

}
