package ar.com.tecnosoftware.somos.report;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import ar.com.tecnosoftware.somos.report.conexion.Conexion;
import lombok.Data;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
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

    private String imagen = "/imagenes/logo.jpg";

    @Autowired
    ApplicationContext context;

    @Autowired
    private Conexion conexion;

    private Map<String, Object> parameters;

    public ReporteUtil() {
        parameters = new HashMap<>();
    }

    public void copilarReporte() {
        Resource resource = context.getResource("classpath:reportes/".concat(reportFileName).concat(".jrxml"));
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();

        setJasperReport(JasperCompileManager.compileReport(inputStream));
            JRSaver.saveObject(jasperReport, reportFileName.replace(".jrxml", ".jasper"));
        } catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");
            e.printStackTrace();
        } catch (JRException e) {
            LOG.error("ERROR al copilar o guardar reporte. Excepcion JRException");
            e.printStackTrace();
        }
    }


    public void generarReportePdf(HttpServletResponse response){
        try {
            copilarReporte();
            parameters.put("logo", this.getClass().getResourceAsStream(imagen));
            setJasperPrint(JasperFillManager.fillReport(getJasperReport(), parameters, conexion.conectar()));
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            JasperExportManager.exportReportToPdfStream(getJasperPrint(), response.getOutputStream());
            LOG.info("METHOD generarReporte --- Reporte generado Exitosamente");
        } catch (JRException ex) {
            LOG.error("JRException");
            ex.printStackTrace();
        } catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");
            e.printStackTrace();
        }
    }

    public void getReporteExcel(HttpServletResponse response){
        try {
            copilarReporte();
            response.setHeader("Content-Disposition", "attachment; filename=\"reporte.xlsx\";");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("application/xlsx");


            setJasperPrint(JasperFillManager.fillReport(getJasperReport(), parameters, conexion.conectar()));

            Exporter jrExporter = new JRXlsxExporter();
            jrExporter.setExporterInput(new SimpleExporterInput(getJasperPrint()));
            jrExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();


            //Sin esto, JASPER solo coloca tantas filas de datos en una sola pestaña como quepan dentro de la Altura de página
            xlsReportConfiguration.setOnePagePerSheet(true);
            //Elimina una fila con una altura de fila muy grande al final de la pestaña de datos.
            xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
            // Elimina las columnas vacías, como las causadas por los márgenes o la distribución deficiente.
            xlsReportConfiguration.setRemoveEmptySpaceBetweenColumns(true);
            /*
            Trata las fechas como fechas, números como números, en lugar de tratar todo como texto
             */
            xlsReportConfiguration.setDetectCellType(true);
            /*
            Muestra las líneas de cuadrícula de Excel, de lo contrario obtendrá un blanco sólido.
             */
            xlsReportConfiguration.setWhitePageBackground(true);
            /*
            Le dice a Excel que no elimine el gráfico del logotipo de la empresa. "true" (es el valor predeterminado) y  elimina los gráficos.
             */
            xlsReportConfiguration.setIgnoreGraphics(false);
           /*
            Congela el numero de filas superiores que le indiquemos. Una vez en Excel, la fila del nombre del informe,
             logotipo de la empresa y la fila de los encabezados de las columnas se congelan,
             y el usuario puede desplazarse por miles de registros y seguir viéndolos.
             */
            xlsReportConfiguration.setFreezeRow(6);

            jrExporter.setConfiguration(xlsReportConfiguration);

            if (jrExporter != null) {
                try {
                    jrExporter.exportReport();
                    LOG.info("METHOD generarReporte --- Reporte generado Exitosamente");
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }

        } catch (JRException ex) {
            LOG.error("JRException");
            ex.printStackTrace();
        } catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");
            e.printStackTrace();
        }

    }
}