package ar.com.tecnosoftware.somos.report;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ReporteUtil {

    private String reportFileName;

    private JasperReport jasperReport;

    private JasperPrint jasperPrint;

    private Resource resource;

    @Autowired
    ApplicationContext context;

    private Map<String, Object> parameters;

    public ReporteUtil() {
        parameters = new HashMap<>();
    }

    public void prepareReport() {
        compileReport();
    }

    public void compileReport() {
        try {
            Resource resource = context.getResource("classpath:reportes/".concat(reportFileName).concat(".jrxml"));
            InputStream inputStream = resource.getInputStream();
            jasperReport = JasperCompileManager.compileReport(inputStream);
            JRSaver.saveObject(jasperReport, reportFileName.replace(".jrxml", ".jasper"));
        } catch (JRException | IOException e) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void fillReport(HttpServletResponse response, JRDataSource dataSource) {
        try {
            parameters.put("datasource",dataSource);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        } catch (JRException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}