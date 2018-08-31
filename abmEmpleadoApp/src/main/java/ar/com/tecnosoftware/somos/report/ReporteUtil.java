package ar.com.tecnosoftware.somos.report;

import ar.com.tecnosoftware.somos.report.conexion.Conexion;
import lombok.Data;
import net.sf.jasperreports.engine.*;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class ReporteUtil {

    private final Log LOG = LogFactory.getLog(ReporteUtil.class);
    private String reportFileName;
    private JasperReport jasperReport;
    private Resource resourceReport;
    private JasperPrint jasperPrint;
    private InputStream inputStream;

    @Autowired
    ApplicationContext context;
    @Autowired
    private Conexion conexion;

    private Map<String, Object> parameters;

    public ReporteUtil() {
        parameters = new HashMap<>();
    }

    public void copilarReporte(String reportFileName) {
        setReportFileName(reportFileName);
        setResourceReport(context.getResource("classpath:reportes/".concat(getReportFileName()).concat(".jrxml")));
        try {
            setInputStream(getResourceReport().getInputStream());
            setJasperReport(JasperCompileManager.compileReport(getInputStream()));
        } catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");
            e.printStackTrace();
        } catch (JRException e) {
            LOG.error("ERROR al copilar o guardar reporte. Excepcion JRException");
            e.printStackTrace();
        }
    }

    public void llenarReporte() {
        File path = new File("src/main/resources/reportes/imagenes/logo.jpg");
        parameters.put("imagen", path.getAbsolutePath());
        try {
            setJasperPrint(JasperFillManager.fillReport(getJasperReport(), parameters, conexion.conectar()));
        } catch (JRException e) {
            LOG.error("JRException");
            e.printStackTrace();
        }
    }

    public void obtenerReporte(String reportFileName) {
        copilarReporte(reportFileName);
        llenarReporte();
    }

}