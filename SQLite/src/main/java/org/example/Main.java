package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("-------------------------------------------------------------------------------------");
        while (!exit) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Introducir los datos del empleado a la base de datos.");
            System.out.println("2. Leer los datos en la base de datos.");
            System.out.println("3. Cerrar el programa.");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarEmpleado(scanner);
                    break;
                case 2:
                    leerEmpleados();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción invalida. por favor selecciona una opción válida.");
            }
            System.out.println("-------------------------------------------------------------------------------------");
        }

        scanner.close();
    }

    private static void insertarEmpleado(Scanner scanner) {
        System.out.print("Introduce el id del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Introduce el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce la edad del empleado: ");
        int edad = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Introduce el correo del empleado: ");
        String correo = scanner.nextLine();

        try (Connection conn = Datos.conectar();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO empleados (id, nombre, edad, correo) VALUES (?, ?, ?, ?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, edad);
            pstmt.setString(4, correo);
            pstmt.executeUpdate();
            System.out.println("Empleat introduït correctament.");
        } catch (SQLException e) {
            System.out.println("Error durant la inserció de dades: " + e.getMessage());
        }
    }

    private static void leerEmpleados() {
        try (Connection conn = Datos.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM empleados")) {

            System.out.println("Dades dels empleats:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nombre: " + rs.getString("nombre") +
                        ", Edad: " + rs.getInt("edad") +
                        ", Correo: " + rs.getString("correo"));
            }
        } catch (SQLException e) {
            System.out.println("Error durant la lectura de dades: " + e.getMessage());
        }
    }
}
