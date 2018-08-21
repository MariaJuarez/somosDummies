package ar.com.tecnosoftware.somos.components;

import ar.com.tecnosoftware.somos.report.SimpleReportExporter;
import ar.com.tecnosoftware.somos.report.SimpleReportFiller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class JasperRerportsSimpleConfig {


  /* Rompe si esta sin comentar, configurar luego para la base de datos real
   @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).addScript("classpath:empleados-tabla.sql").build();
    }*/

    @Bean
    public SimpleReportFiller reportFiller() {
        return new SimpleReportFiller();
    }

    @Bean
    public SimpleReportExporter reportExporter() {
        return new SimpleReportExporter();
    }

}