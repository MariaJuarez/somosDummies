package ar.com.tecnosoftware.somos.usuario.controller;

import ar.com.tecnosoftware.somos.usuario.entity.Usuario;
import ar.com.tecnosoftware.somos.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/crear")
    public void addUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.add(usuario);
    }

    @GetMapping (value = "/listarActivos")
    public List<Usuario> findUsuarioActivos(){ return usuarioService.buscarNoBajas();}

    @GetMapping (value = "/listarTodos")
    public List<Usuario> findAllUsuario(){ return usuarioService.buscarTodos();}

    @PutMapping (value = "/baja/{id}")
    public void bajaUsuario(@PathVariable int id) {
        usuarioService.darBaja(id);
    }

    @PutMapping (value = "/baja/empleadoDeUsuario")
    public void bajaUsuarioConEmpleado(@RequestBody Usuario usuario) {
        usuarioService.darBajaEmpleadoDeUsuario(usuario);
    }

    @PutMapping(value = "/editar")
    public void editarUsuario(@RequestBody Usuario usuario){
        usuarioService.editar(usuario);
    }
}
