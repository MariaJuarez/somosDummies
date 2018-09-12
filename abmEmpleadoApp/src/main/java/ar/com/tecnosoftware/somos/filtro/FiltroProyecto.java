package ar.com.tecnosoftware.somos.filtro;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import lombok.Data;

import java.util.Date;

@Data
public class FiltroProyecto {

    private Date fechaInicio = null;

    private Date fechaFin = null;

    private Cliente cliente = null;

}
