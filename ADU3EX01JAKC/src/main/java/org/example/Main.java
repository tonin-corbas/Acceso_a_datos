package org.example;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("C:\\Users\\Toñin\\IdeaProjects\\Acceso_a_datos\\ADU3EX01JAKC\\db\\personas.odb");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        try{
            while (!exit) {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Añadir persona");
                System.out.println("2. Borrar Persona");
                System.out.println("3. Modificar Persona");
                System.out.println("4. Mostrar todas las Persones");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opción: ");

                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir línia

                switch (option) {
                    case 1 -> aniadirPersona(scanner);
                    case 2 -> borrarPersona(scanner);
                    case 3 -> modificarPersona(scanner);
                    case 4 -> mostrarTodas();
                    case 5 -> exit = true;
                    default -> System.out.println("Opción no válida.");
                }
            }
        }catch (Exception e){
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        em.close();
        emf.close();
        scanner.close();
    }

    private static void aniadirPersona(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir línia
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Persona persona = new Persona(nombre, edad, email);
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        System.out.println("Persona añadida!");
    }

    private static void borrarPersona(Scanner scanner) {
        System.out.print("Nombre de la persona a borrar: ");
        String nom = scanner.nextLine();
        Persona persona = em.find(Persona.class, nom);

        if (persona != null) {
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();
            System.out.println("Persona borrada!");
        } else {
            System.out.println("Persona no encontrada en la base de datos");
        }
    }

    private static void modificarPersona(Scanner scanner) {
        System.out.print("Nombre de la persona a modificar: ");
        String nom = scanner.nextLine();
        Persona persona = em.find(Persona.class, nom);

        if (persona != null) {
            System.out.print("Nueva edad (dejar en blanco si no se quiere modificar): ");
            String edatInput = scanner.nextLine();
            if (!edatInput.isBlank()) {
                persona.setEdat(Integer.parseInt(edatInput));
            }

            System.out.print("Nuevo email (dejar en blanco si no se quiere modificar): ");
            String emailInput = scanner.nextLine();
            if (!emailInput.isBlank()) {
                persona.setEmail(emailInput);
            }

            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();
            System.out.println("Persona modificada!");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    private static void mostrarTodas() {
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        List<Persona> persones = query.getResultList();

        if (persones.isEmpty()) {
            System.out.println("No hay en la base de datos");
        } else {
            persones.forEach(System.out::println);
        }
    }
}
