package org.example;

import java.sql.*;

// Clase que se usa para hacer la conexión inicial con la base de datos
public class Datos {
    private static final String DB_URL = "jdbc:sqlite:SQLite/src/main/resources/empresa.db";

//  Constructor que hace la conexión
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public static void eliminarEmpleado(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún empleado con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        }
    }
}
