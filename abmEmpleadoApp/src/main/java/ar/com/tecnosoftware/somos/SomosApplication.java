package ar.com.tecnosoftware.somos;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class SomosApplication {

	public static void main(String[] args) throws JRException, SQLException, ClassNotFoundException {
		SpringApplication.run(SomosApplication.class, args);
	//	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/somosdb?useSSL=false", "root", "1234");

/*PRUEBAS PARA REPORTES
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				"C:\\Users\\mjuarez\\Documents\\somosTecno\\abmEmpleadoApp\\src\\main\\resources\\report1.jasper", null);
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteEmpleado.pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();

		// se muestra en una ventana aparte para su descarga
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"C:\\Users\\mjuarez\\Documents\\somosTecno\\abmEmpleadoApp\\src\\main\\resources\\report1.jasper", null);
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
		jasperViewer.setVisible(true);
*/

	}

}
