package ar.com.tecnosoftware.somos.report;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import ar.com.tecnosoftware.somos.report.conexion.Conexion;
import lombok.Data;
import net.sf.jasperreports.engine.*;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Data
@Component
public class ReporteUtil {

    private final Log LOG = LogFactory.getLog(ReporteUtil.class);

    private String reportFileName;

    private JasperReport jasperReport;

    private JasperPrint jasperPrint;

    private Resource resource;

    private JRDataSource dataSource;

    private String imagen="/imagenes/logo.jpg";

    @Autowired
    ApplicationContext context;

    @Autowired
    private Conexion conexion;

    private Map<String, Object> parameters;

    public ReporteUtil() {
        parameters = new HashMap<>();
    }

    public void generarReportePdf(HttpServletResponse response) {
        try {
            Resource resource = context.getResource("classpath:reportes/".concat(reportFileName).concat(".jasper"));
            InputStream inputStream = resource.getInputStream();
            parameters.put("logo", this.getClass().getResourceAsStream(imagen));
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, conexion.conectar());
           // response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
            LOG.info("METHOD generarReporte --- Reporte generado Exitosamente");
        } catch (JRException ex) {
            LOG.error("JRException");
            ex.printStackTrace();
        } catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");
        }
    }

    public void generarReporteExcel(HttpServletResponse response) {
        try {
            Resource resource = context.getResource("classpath:reportes/".concat(reportFileName).concat(".jasper"));
            InputStream inputStream = resource.getInputStream();
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, null, conexion.conectar());
            response.setContentType(MediaType.ALL_VALUE);
            JasperExportManager.exportReportToXmlStream(jasperPrint, response.getOutputStream());

                  //s  exportReportToPdfStream(jasperPrint, response.getOutputStream());
            LOG.info("METHOD generarReporte --- Reporte generado Exitosamente");
        } catch (JRException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");        }
    }
}