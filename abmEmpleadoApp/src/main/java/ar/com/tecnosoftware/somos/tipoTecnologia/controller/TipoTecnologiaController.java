package ar.com.tecnosoftware.somos.tipoTecnologia.controller;

import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tecnologia.service.TecnologiaService;
import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;
import ar.com.tecnosoftware.somos.tipoTecnologia.service.TipoTecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tipoTecnologia")
public class TipoTecnologiaController {

    @Autowired
    private TipoTecnologiaService tipoTecnologiaService;

    @Autowired
    private TecnologiaService tecnologiaService;

    @PostMapping(value = "/crear")
    public void addTipoTecnologia(@Valid @RequestBody TipoTecnologia tipoTecnologia) {
        tipoTecnologiaService.add(tipoTecnologia);
    }

    @GetMapping (value = "/listar")
    public List<TipoTecnologia> findAllTipoTecnologia(){
        return tipoTecnologiaService.buscarTodos();
    }

    @PutMapping (value = "/baja/tipoTecnologia/{id}")
    public void bajaTipoTecnologia(@PathVariable int id, @RequestBody List<Tecnologia> tecnologias) {
        tecnologiaService.darBajaTipoTecnologiasDeTecnologias(tecnologias);
        tipoTecnologiaService.darBaja(id);
    }

}
