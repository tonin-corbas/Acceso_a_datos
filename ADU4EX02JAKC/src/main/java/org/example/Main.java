package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Define la URL de conexión a la base de datos. Asegúrate de mantener esta información confidencial.
    private static final String DB_URL = "jdbc:mysql://adu4ex02jakc";
    private static final String DB_NAME = "adu4ex02jakc";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    // Inicializa el sessionFactory de Hibernate para manejar la conexión con la base de datos.
    private static final SessionFactory sessionFactory = createSessionFactory();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu(); // Muestra el menú principal.
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> agregarAutor(); // Agrega un nuevo autor.
                case 2 -> agregarLlibre(); // Agrega un nuevo libro.
                case 3 -> listarAutores(); // Lista todos los autores.
                case 4 -> listarLibros(); // Lista todos los libros.
                case 5 -> eliminarLlibre(); // Elimina un libro.
                case 6 -> eliminarAutor(); // Elimina un autor.
                case 7 -> {
                    System.out.println("Saliendo...");
                    sessionFactory.close(); // Cierra el sessionFactory antes de salir.
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    // Método para mostrar el menú principal con las opciones disponibles para el usuario.
    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Agregar Autor");
        System.out.println("2. Agregar Llibre");
        System.out.println("3. Listar Autores");
        System.out.println("4. Listar Libros");
        System.out.println("5. Eliminar Llibre");
        System.out.println("6. Eliminar Autor");
        System.out.println("7. Salir");
        System.out.print("Selecciona una opción: ");
    }

    // Inicializa y configura Hibernate.
    // Verifica y crea la base de datos en caso de que no existe.
    private static SessionFactory createSessionFactory() {
        try {
            createDatabaseIfNotExists();
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Error al configurar Hibernate: " + e.getMessage(), e);
        }
    }

    // Este método verifica si la base de datos y las tablas necesarias existen, y las crea si no es así.
    private static void createDatabaseIfNotExists() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            // Verifica si la base de datos existe
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);

            // Conectar a la base de datos para crear tablas si no existen
            String useDatabase = "USE " + DB_NAME;
            statement.executeUpdate(useDatabase);

            String createTableAutor = """
                    CREATE TABLE IF NOT EXISTS Autor (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(255) NOT NULL,
                        dataNaixement DATE NOT NULL
                    );
                    """;

            String createTableLlibre = """
                    CREATE TABLE IF NOT EXISTS Llibre (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        titol VARCHAR(255) NOT NULL,
                        anyPublicacio INT NOT NULL,
                        autor_id INT NOT NULL,
                        CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES Autor(id) ON DELETE CASCADE
                    );
                    """;

            statement.executeUpdate(createTableAutor);
            statement.executeUpdate(createTableLlibre);
            System.out.println("Base de datos y tablas creadas o verificadas correctamente.");

        } catch (SQLException e) {
            throw new RuntimeException("Error al crear la base de datos o tablas: " + e.getMessage(), e);
        }
    }

    // Método para agregar un nuevo autor a la base de datos. Solicita los datos al usuario y los guarda.
    private static void agregarAutor() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.print("Nombre del autor: ");
            String nombre = scanner.nextLine();

            System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
            String fechaNacimiento = scanner.nextLine();

            Autor autor = new Autor();
            autor.setNom(nombre);
            autor.setDataNaixement(LocalDate.parse(fechaNacimiento));

            session.save(autor);
            transaction.commit();
            System.out.println("Autor agregado exitosamente.");
        }
    }

    // Método para agregar un nuevo libro a la base de datos, asociándolo con un autor existente.
    private static void agregarLlibre() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.print("Título del libro: ");
            String titulo = scanner.nextLine();

            System.out.print("Año de publicación: ");
            int anyPublicacio = Integer.parseInt(scanner.nextLine());

            listarAutores(); // Muestra la lista de autores para seleccionar uno.
            System.out.print("ID del autor: ");
            int autorId = Integer.parseInt(scanner.nextLine());

            Autor autor = session.get(Autor.class, autorId);
            if (autor == null) {
                System.out.println("Autor no encontrado.");
                return;
            }

            Llibre llibre = new Llibre();
            llibre.setTitol(titulo);
            llibre.setAnyPublicacio(anyPublicacio);
            llibre.setAutor(autor);

            session.save(llibre);
            transaction.commit();
            System.out.println("Libro agregado exitosamente.");
        }
    }

    // Método para listar todos los autores registrados en la base de datos.
    private static void listarAutores() {
        try (Session session = sessionFactory.openSession()) {
            List<Autor> autores = session.createQuery("from Autor", Autor.class).list();
            if (autores.isEmpty()) {
                System.out.println("No hay autores registrados.");
            } else {
                System.out.println("\n===== LISTA DE AUTORES =====");
                for (Autor autor : autores) {
                    System.out.println("ID: " + autor.getId() + " | Nombre: " + autor.getNom() + " | Fecha de Nacimiento: " + autor.getDataNaixement());
                }
            }
        }
    }

    // Método para listar todos los libros registrados en la base de datos, incluyendo información del autor.
    private static void listarLibros() {
        try (Session session = sessionFactory.openSession()) {
            List<Llibre> libros = session.createQuery("from Llibre", Llibre.class).list();
            if (libros.isEmpty()) {
                System.out.println("No hay libros registrados.");
            } else {
                System.out.println("\n===== LISTA DE LIBROS =====");
                for (Llibre llibre : libros) {
                    System.out.println("ID: " + llibre.getId() + " | Título: " + llibre.getTitol() +
                            " | Año: " + llibre.getAnyPublicacio() + " | Autor: " + llibre.getAutor().getNom());
                }
            }
        }
    }

    // Método para eliminar un libro de la base de datos, identificado por su ID.
    private static void eliminarLlibre() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.print("ID del libro a eliminar: ");
            int llibreId = Integer.parseInt(scanner.nextLine());

            Llibre llibre = session.get(Llibre.class, llibreId);
            if (llibre == null) {
                System.out.println("Libro no encontrado.");
                return;
            }

            session.delete(llibre);
            transaction.commit();
            System.out.println("Libro eliminado exitosamente.");
        }
    }

    // Método para eliminar un autor y todos los libros asociados de la base de datos, identificado por su ID.
    private static void eliminarAutor() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.print("ID del autor a eliminar: ");
            int autorId = Integer.parseInt(scanner.nextLine());

            Autor autor = session.get(Autor.class, autorId);
            if (autor == null) {
                System.out.println("Autor no encontrado.");
                return;
            }

            session.delete(autor);
            transaction.commit();
            System.out.println("Autor y sus libros asociados eliminados exitosamente.");
        }
    }
}
