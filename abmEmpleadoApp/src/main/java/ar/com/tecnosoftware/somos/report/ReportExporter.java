package ar.com.tecnosoftware.somos.report;

import lombok.Data;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
@Component
public class ReportExporter {

    private final Log LOG = LogFactory.getLog(ReportExporter.class);


    @Autowired
    ReporteUtil reporteUtil;

    private JasperPrint jasperPrint;

    public void exportarPdf(String reportFileName, HttpServletResponse response){

        reporteUtil.obtenerReporte(reportFileName);
        try {

            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            JasperExportManager.exportReportToPdfStream(reporteUtil.getJasperPrint(), response.getOutputStream());
            LOG.info("METHOD generarReporte --- Reporte generado Exitosamente");
        } catch (JRException ex) {
            LOG.error("JRException");
            ex.printStackTrace();
        } catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");
            e.printStackTrace();
        }
    }

    public void exportarXlsx(String reportFileName, HttpServletResponse response) {

        reporteUtil.obtenerReporte(reportFileName);

        try {
            response.setHeader("Content-Disposition", "attachment; filename=\"reporte.xlsx\";");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            //    response.setContentType("application/xlsx");
            response.setContentType(response.getContentType());

            Exporter jrExporter = new JRXlsxExporter();
            jrExporter.setExporterInput(new SimpleExporterInput(reporteUtil.getJasperPrint()));
            jrExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();


            //Sin esto, JASPER solo coloca tantas filas de datos en una sola pestaña como quepan dentro de la Altura de página
            xlsReportConfiguration.setOnePagePerSheet(true);
            //Elimina una fila con una altura de fila muy grande al final de la pestaña de datos.
            xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
            // Elimina las columnas vacías, como las causadas por los márgenes o la distribución deficiente.
          //  xlsReportConfiguration.setRemoveEmptySpaceBetweenColumns(true);
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

        }  catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");
            e.printStackTrace();
        }

    }

    public void exportarCsv(String reportFileName, HttpServletResponse response) throws IOException {
        reporteUtil.obtenerReporte(reportFileName);
        JRCsvExporter exporter = new JRCsvExporter();

        exporter.setExporterInput(new SimpleExporterInput(reporteUtil.getJasperPrint()));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(response.getOutputStream()));

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exportToHtml(String fileName) {
        HtmlExporter exporter = new HtmlExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(fileName));

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exportTxt(String reportFileName, HttpServletResponse response){
        reporteUtil.obtenerReporte(reportFileName);
        try {
            response.setHeader("Content-Disposition", "attachment; filename=\"reporte.txt\";");
          //  response.setHeader("Content-Disposition", "attachment; filename=\"".concat(reporteUtil.getReportFileName()).concat("\";"));
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("application/text");

            JRTextExporter textExporter = new JRTextExporter();
            textExporter.setExporterInput(new SimpleExporterInput(reporteUtil.getJasperPrint()));
            textExporter.setExporterOutput(new SimpleWriterExporterOutput(response.getOutputStream()));
            SimpleTextReportConfiguration reportConfiguration = new SimpleTextReportConfiguration();
            reportConfiguration.setCharHeight(10f);
            reportConfiguration.setCharWidth(20f);
            textExporter.setConfiguration(reportConfiguration);

            SimpleTextExporterConfiguration configuration = new SimpleTextExporterConfiguration();
            configuration.setLineSeparator("\r\n");
            textExporter.setConfiguration(configuration);
          //  configuration.setPageSeparator();
           // configuration.setTrimLineRight();

            // set content dispostion to attachment in with file name.
            // case the open/save dialog needs to appear.
            response.setHeader("Content-Disposition", "attachment;filename="+reportFileName+".txt");
            if (textExporter != null) {
                try {
                    textExporter.exportReport();
                    LOG.info("METHOD generarReporte --- Reporte generado Exitosamente");
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }

        }  catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");
            e.printStackTrace();
        }
    }

    public void exportJson(String reportFileName, HttpServletResponse response){
        reporteUtil.obtenerReporte(reportFileName);
        try {
            response.setHeader("Content-Disposition", "attachment; filename=\"reporte.txt\";");
            //  response.setHeader("Content-Disposition", "attachment; filename=\"".concat(reporteUtil.getReportFileName()).concat("\";"));
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("application/text");

            JRTextExporter textExporter = new JRTextExporter();
            textExporter.setExporterInput(new SimpleExporterInput(reporteUtil.getJasperPrint()));
            textExporter.setExporterOutput(new SimpleWriterExporterOutput(response.getOutputStream()));
            SimpleTextReportConfiguration reportConfiguration = new SimpleTextReportConfiguration();
            reportConfiguration.setCharHeight(10f);
            reportConfiguration.setCharWidth(20f);
            textExporter.setConfiguration(reportConfiguration);

            SimpleTextExporterConfiguration configuration = new SimpleTextExporterConfiguration();
            configuration.setLineSeparator("\r\n");
            textExporter.setConfiguration(configuration);
            //  configuration.setPageSeparator();
            // configuration.setTrimLineRight();

            // set content dispostion to attachment in with file name.
            // case the open/save dialog needs to appear.
            response.setHeader("Content-Disposition", "attachment;filename="+reportFileName+".txt");
            if (textExporter != null) {
                try {
                    textExporter.exportReport();
                    LOG.info("METHOD generarReporte --- Reporte generado Exitosamente");
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }

        }  catch (IOException e) {
            LOG.error("IOException --- No existe el reporte o la ubicacion ingresada");
            e.printStackTrace();
        }
    }



}