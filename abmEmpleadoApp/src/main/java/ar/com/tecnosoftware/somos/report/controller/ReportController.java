package ar.com.tecnosoftware.somos.report.controller;

import ar.com.tecnosoftware.somos.report.ReporteUtil;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final Log LOG = LogFactory.getLog(ReportController.class);
    @Autowired
    ApplicationContext context;

    @Autowired
    ReporteUtil reporteUtil;

    @GetMapping(path = "/pdf/{reportFileName}")
    @ResponseBody
    public void getPdf(HttpServletResponse response, @PathVariable("reportFileName") String reportFileName) {
                LOG.info("METHOD: getPdf --- Obteniendo el reporte de ".concat(reportFileName));
                reporteUtil.setReportFileName(reportFileName);
                reporteUtil.generarReportePdf(response);
        }

    @GetMapping(path = "/excel/{reportFileName}")
    @ResponseBody
    public void getExcel(HttpServletResponse response, @PathVariable("reportFileName") String reportFileName) {
        LOG.info("METHOD: getExcel --- Obteniendo el reporte de ".concat(reportFileName));
        reporteUtil.setReportFileName(reportFileName);
        reporteUtil.generarReporteExcel(response);
    }
}

