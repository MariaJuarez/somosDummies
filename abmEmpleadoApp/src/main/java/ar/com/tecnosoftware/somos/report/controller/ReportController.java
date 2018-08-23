package ar.com.tecnosoftware.somos.report.controller;

import ar.com.tecnosoftware.somos.entity.Area;
import ar.com.tecnosoftware.somos.report.ReporteUtil;
import ar.com.tecnosoftware.somos.repository.AreaRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final Log LOG = LogFactory.getLog(ReportController.class);
    @Autowired
    ApplicationContext context;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    ReporteUtil reporteUtil;

    @GetMapping(path = "/pdf/{reportFileName}")
    @ResponseBody
    public void getPdf(HttpServletResponse response, @PathVariable("reportFileName") String reportFileName) throws Exception {
        reporteUtil.setReportFileName(reportFileName);
        LOG.info("METHOD: getPdf -- Obteniendo Reporte de "+reportFileName);
        reporteUtil.compileReport();
        List<Area> areas = (List<Area>) areaRepository.buscarTodos();
        JRDataSource dataSource = new JRBeanCollectionDataSource(areas);
        reporteUtil.fillReport(response, dataSource);
    }

}
