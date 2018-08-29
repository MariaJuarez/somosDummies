package ar.com.tecnosoftware.somos.report;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import ar.com.tecnosoftware.somos.report.conexion.Conexion;
import lombok.Data;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
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

import javax.faces.context.FacesContext;
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
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
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

    //exporta a xls
    /*
    Leer mas en https://community.jaspersoft.com/wiki/tips-exporting-excel
     */
    public void exportXls(HttpServletResponse response) throws IOException
    {
        try{
            Resource resource = context.getResource("classpath:reportes/".concat(reportFileName).concat(".jasper"));
            InputStream inputStream = resource.getInputStream();
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, null, conexion.conectar());
            ByteArrayOutputStream output = new ByteArrayOutputStream ();
        //    OutputStream outputfile = new FileOutputStream(new File ("classpath:reportes/".concat(reportFileName).concat(".xls")));

            // coding For Excel:
            JRXlsExporter exporterXLS = new JRXlsExporter();
            exporterXLS.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporterXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(output));
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
            xlsReportConfiguration.setWhitePageBackground(false);
            /*
            Le dice a Excel que no elimine el gráfico del logotipo de la empresa. "true" (es el valor predeterminado) y  elimina los gráficos.
             */
            xlsReportConfiguration.setIgnoreGraphics(false);
           /*
            Congela el numero de filas superiores que le indiquemos. Una vez en Excel, la fila del nombre del informe,
             logotipo de la empresa y la fila de los encabezados de las columnas se congelan,
             y el usuario puede desplazarse por miles de registros y seguir viéndolos.
             */
            xlsReportConfiguration.setFreezeRow(4);

            exporterXLS.exportReport();
            LOG.info("METHOD generarReporte --- Reporte generado Exitosamente");
            //outputfile.write(output.toByteArray());








         /*   Resource resource = context.getResource("classpath:reportes/".concat(reportFileName).concat(".jasper"));
            InputStream inputStream = resource.getInputStream();
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, null, conexion.conectar());
            JRXlsExporter xlsExporter = new JRXlsExporter();
            xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportFileName));
            SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
            SimpleXlsExporterConfiguration xlsExporterConfiguration = new SimpleXlsExporterConfiguration();
            xlsReportConfiguration.setOnePagePerSheet(false);
            xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
            xlsReportConfiguration.setDetectCellType(true);
            xlsReportConfiguration.setWhitePageBackground(false);
            xlsExporter.setConfiguration(xlsReportConfiguration);
            xlsExporter.exportReport();*/

        }catch(JRException e)
        {
            System.out.println(e);
        }

    }

    public void getReporteExcel(HttpServletResponse response) throws IOException {

        Resource resource = context.getResource("classpath:reportes/".concat(reportFileName).concat(".jasper"));
        InputStream inputStream = resource.getInputStream();
        //Se definen los parametros si es que el reporte necesita


        try {
           // File file = new File(String.valueOf(resource));


            // response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            response.setHeader("Content-Disposition", "attachment; filename=\"reporte.xlsx\";");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("application/xlsx");


            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, conexion.conectar());

            JRExporter jrExporter = jrExporter = new JRXlsxExporter();
            jrExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                    //setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
                //    setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());

            SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
            xlsReportConfiguration.setOnePagePerSheet(false);
            xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
            xlsReportConfiguration.setDetectCellType(true);
            xlsReportConfiguration.setWhitePageBackground(false);
            jrExporter.setConfiguration(xlsReportConfiguration);


            if (jrExporter != null) {
                try {
                    jrExporter.exportReport();
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    /*public void getReporteExcel(HttpServletResponse response) throws ClassNotFoundException, InstantiationException, IllegalAccessException{

        //Se definen los parametros si es que el reporte necesita
        Map parameter = new HashMap();

        try {
            Resource resource = context.getResource("classpath:reportes/".concat(reportFileName).concat(".jasper"));
            InputStream inputStream = resource.getInputStream();
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameter, conexion.conectar());
           // File file = new File(ruta);

             response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            response.setHeader("Content-Disposition", "attachment; filename=\"reporte.XLSX\";");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("application/XLSX");
            JRExporter jrExporter = null;
            jrExporter = new JRXlsxExporter();
            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());

            if (jrExporter != null) {
                try {
                    jrExporter.exportReport();
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}}