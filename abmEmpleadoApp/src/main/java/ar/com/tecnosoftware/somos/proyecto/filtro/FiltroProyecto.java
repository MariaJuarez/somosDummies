package ar.com.tecnosoftware.somos.proyecto.filtro;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FiltroProyecto {

    private Date fechaInicio = null;

    private Date fechaFin = null;

    private Cliente cliente = null;

}
