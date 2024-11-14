package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Datos.conectar;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        //Bucle principal del proyecto
        System.out.println("-------------------------------------------------------------------------------------");
        while (!exit) {
            System.out.println("Menú Principal:");
            System.out.println("1. Introducir los datos del empleado a la base de datos.");
            System.out.println("2. Leer los datos en la base de datos.");
            System.out.println("3. Eliminar un empleado de la base de datos.");
            System.out.println("4. Cerrar el programa.");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

//            Switch que se encarga de gesionar las opciones seleccionadas por el user
            switch (opcion) {
                case 1:
                    insertarEmpleado(scanner);
                    break;
                case 2:
                    leerEmpleados();
                    break;
                case 3:
                    eliminarEmpleado(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción invalida. por favor selecciona una opción válida.");
            }
            System.out.println("-------------------------------------------------------------------------------------");
        }

        scanner.close();
    }

    //     Método que se utiliza para insertar empleados dentro de la BBDD
    private static void insertarEmpleado(Scanner scanner) {
        System.out.print("Introduce el id del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de linea pendiente

        System.out.print("Introduce el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce la edad del empleado: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de linea pendiente3

        System.out.print("Introduce el correo del empleado: ");
        String correo = scanner.nextLine();

        // try-catch que sirve para insertar los datos dentro de la propia BBDD
        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO empleados (id, nombre, edad, correo) VALUES (?, ?, ?, ?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, edad);
            pstmt.setString(4, correo);
            pstmt.executeUpdate();
            System.out.println("Empleado introducido correctamente.");
        }
//        El catch muestra los errores posibles en caso de que no se haya podido insertar los datos
        catch (SQLException e) {
            System.out.println("Error durante la inserción de datos: " + e.getMessage());
        }
    }

    //    Método utilizado para leer la base de datos
    private static void leerEmpleados() {
//        Comprueba que haya conexión con la BBDD y en caso contrario muestre el error en pantalla
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM empleados")) {

            System.out.println("Datos de los empleados:");
            // Bucle principal para pintar todos los datos de la BBDD
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nombre: " + rs.getString("nombre") +
                        ", Edad: " + rs.getInt("edad") +
                        ", Correo: " + rs.getString("correo"));
            }
        } catch (SQLException e) {
            System.out.println("Error durante la lectura de datos: " + e.getMessage());
        }
    }

//    Método usado para eliminar empleados llamando al método en la clase Datos
    private static void eliminarEmpleado(Scanner scanner) {
        System.out.print("Introduce el ID del empleado que deseas eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Datos.eliminarEmpleado(id);
    }
}
