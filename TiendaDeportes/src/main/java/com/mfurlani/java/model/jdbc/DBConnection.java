package com.mfurlani.java.model.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {
    private static final Logger logger = LoggerFactory.getLogger(DBConnection.class);
    
    // 1. Corregimos el nombre de la variable
    private static DBConnection instance = null;
    private Connection connection = null;

    // 2. Constructor privado corregido (sin parámetros para el Singleton interno)
    private DBConnection() {
        super();
    }

    private void init() throws SQLException {
        Properties properties = new Properties();
        
        // 3. Uso de TRY-WITH-RESOURCES para cerrar el InputStream automáticamente [6, 7]
        try (InputStream dbStream = getClass().getClassLoader().getResourceAsStream("database.properties")) {
            
            if (dbStream == null) {
                logger.error("El archivo database.properties no se encontró en el classpath");
                throw new SQLException("Configuración de base de datos no encontrada");
            }

            properties.load(dbStream);
            String driver = properties.getProperty("db.driver");
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user", "root");
            String password = properties.getProperty("db.password");

            // 4. Registrar el driver (Opcional en JDBC moderno, pero seguro) [4]
            Class.forName(driver);
            this.connection = DriverManager.getConnection(url, user, password);
            logger.info("Conexión a la base de datos establecida con éxito.");

        } catch (IOException | ClassNotFoundException e) {
            logger.error("Error crítico al inicializar la conexión: ", e);
            throw new SQLException("No se pudo configurar el driver o el archivo de propiedades", e);
        }
    }

    // Método para obtener la conexión interna
    public Connection getConnection() {
        return connection;
    }

    // 5. Singleton con manejo de reconexión
    public static Connection getInstance() throws SQLException {
        // Verificamos si la instancia es nula o si la conexión física se cerró
        if (instance == null || instance.getConnection() == null || instance.getConnection().isClosed()) {
            instance = new DBConnection();
            instance.init();
        }
        return instance.getConnection();
    }
}