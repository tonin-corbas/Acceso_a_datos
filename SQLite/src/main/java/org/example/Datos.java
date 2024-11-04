package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Datos {
    private static final String DB_URL = "jdbc:sqlite:SQLite/src/main/resources/empresa.db";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public static void cerrarConexion(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    private static void createTableIfNotExists() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:empresa.db");
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS empleats (" +
                    "id INTEGER PRIMARY KEY, " +
                    "nom VARCHAR(100), " +
                    "edat INTEGER, " +
                    "correu VARCHAR(100))";
            stmt.execute(sql);
            System.out.println("La taula 'empleats' ha estat verificada o creada.");
        } catch (SQLException e) {
            System.out.println("Error al crear la taula: " + e.getMessage());
        }
    }
}
