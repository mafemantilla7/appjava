import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBD {

    private static final Properties config = new Properties();

    static {
        try (FileInputStream in = new FileInputStream("config.properties")) {
            config.load(in);
        } catch (IOException e) {
            throw new IllegalStateException(
                    "No se encontró config.properties. Copia config.example.properties y completa tus datos.", e);
        }
    }

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(
                    config.getProperty("db.url"),
                    config.getProperty("db.user"),
                    config.getProperty("db.password")
            );
            System.out.println("Conexion exitosa a la base de datos");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return null;
        }
    }
}