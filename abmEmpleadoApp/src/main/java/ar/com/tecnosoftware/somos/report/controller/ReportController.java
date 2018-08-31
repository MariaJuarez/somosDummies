package ar.com.tecnosoftware.somos.report.controller;

import ar.com.tecnosoftware.somos.report.ReportExporter;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/reportes")
public class ReportController {

    private final Log LOG = LogFactory.getLog(ReportController.class);

    @Autowired
    ReportExporter reportExporter;

    @GetMapping(path = "/pdf/{reportFileName}")
    @ResponseBody
    public void getPdf(HttpServletResponse response, @PathVariable("reportFileName") String reportFileName) {
        LOG.info("METHOD: getPdf --- Obteniendo el reporte de ".concat(reportFileName));
        reportExporter.exportarPdf(reportFileName, response);
        }


    @GetMapping(path = "/excel/{reportFileName}")
    public void getExcel(HttpServletResponse response, @PathVariable("reportFileName") String reportFileName) {
        LOG.info("METHOD: getExcel --- Obteniendo el reporte de ".concat(reportFileName));
        reportExporter.exportarXlsx(reportFileName,response);
    }

    @GetMapping(path = "/csv/{reportFileName}")
    public void getCsv(HttpServletResponse response, @PathVariable("reportFileName") String reportFileName) throws IOException {
        LOG.info("METHOD: getCsv --- Obteniendo el reporte de ".concat(reportFileName));
        reportExporter.exportarCsv(reportFileName,response);
    }

    @GetMapping(path = "/txt/{reportFileName}")
    public void getTxt(HttpServletResponse response, @PathVariable("reportFileName") String reportFileName) throws IOException {
        LOG.info("METHOD: getTxt --- Obteniendo el reporte de ".concat(reportFileName));
        reportExporter.exportTxt(reportFileName,response);
    }
}

