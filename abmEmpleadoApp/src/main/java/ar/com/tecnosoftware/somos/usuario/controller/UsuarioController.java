package ar.com.tecnosoftware.somos.usuario.controller;

import ar.com.tecnosoftware.somos.usuario.entity.Usuario;
import ar.com.tecnosoftware.somos.usuario.exception.UsuarioErrorException;
import ar.com.tecnosoftware.somos.usuario.exception.UsuarioNotFoundException;
import ar.com.tecnosoftware.somos.usuario.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/crear")
    public void addUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.add(usuario);
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Usuario>> findUsuarioActivos() throws UsuarioErrorException {
        List<Usuario> usuarios = usuarioService.buscarNoBajas();
        if (usuarios == null) {
            throw new UsuarioErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Usuario>> findAllUsuario() throws UsuarioErrorException {
        List<Usuario> usuarios = usuarioService.buscarTodos();
        if (usuarios == null) {
            throw new UsuarioErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping(value = "/baja/{id}")
    public ResponseEntity<Usuario> bajaUsuario(@PathVariable int id) throws UsuarioNotFoundException {
        Usuario usuario = usuarioService.darBaja(id);
        if (usuario == null) {
            throw new UsuarioNotFoundException("No se encontró el usuario con id " + id);
        }

        return ResponseEntity.ok(usuario);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) throws UsuarioNotFoundException {
        Usuario editado = usuarioService.editar(usuario);
        if (editado == null) {
            throw new UsuarioNotFoundException("No se encontró el usuario con id " + usuario.getId());
        }
        return ResponseEntity.ok(editado);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(UsuarioNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(UsuarioErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(UsuarioErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }
}
