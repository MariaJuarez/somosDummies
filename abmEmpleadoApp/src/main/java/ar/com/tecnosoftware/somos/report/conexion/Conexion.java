package ar.com.tecnosoftware.somos.report.conexion;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Conexion {

    private final Log LOG = LogFactory.getLog(Conexion.class);

    public Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            LOG.info("Conectando a la base de datos Somos");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/somosdb?useSSL=false", "root", "1234");
        } catch (ClassNotFoundException e) {
            LOG.error("Please include Classpath Where your MySQL Driver is located");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            LOG.info("Database Connected");
        } else {
            LOG.info("Connection Failed");
        }
        return conn;
    }

}
