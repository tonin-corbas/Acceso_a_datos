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

        while (!exit) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Introduir dades d'empleat a la base de dades.");
            System.out.println("2. Llegir dades de la base de dades i imprimir-les.");
            System.out.println("3. Sortir del programa.");
            System.out.print("Seleccioneu una opció: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

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
                    System.out.println("Opció invàlida. Si us plau, trieu una opció vàlida.");
            }
        }
        scanner.close();
    }

    private static void insertarEmpleado(Scanner scanner) {
        System.out.print("Introdueix l'ID de l'empleat: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Introdueix el nom de l'empleat: ");
        String nombre = scanner.nextLine();

        System.out.print("Introdueix l'edat de l'empleat: ");
        int edad = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Introdueix el correu de l'empleat: ");
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
                        ", Nom: " + rs.getString("nombre") +
                        ", Edat: " + rs.getInt("edad") +
                        ", Correu: " + rs.getString("correo"));
            }
        } catch (SQLException e) {
            System.out.println("Error durant la lectura de dades: " + e.getMessage());
        }
    }
}
