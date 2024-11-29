package org.example;

import javax.persistence.*; // Importación para trabajar con JPA (Java Persistence API)
import java.util.List; // Importación para manejar listas de datos
import java.util.Scanner; // Importación para leer datos de la consola

/**
 * Clase principal que implementa un programa interactivo para gestionar una base de datos
 * de personas utilizando JPA y ObjectDB.
 */
public class Main {
    // Crea una fábrica de gestores de entidades (EntityManagerFactory).
    // Este objeto inicializa la conexión con la base de datos definida en el persistence.xml.
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/personas.odb");

    // Crea un gestor de entidades (EntityManager) que permite realizar operaciones CRUD en la base de datos.
    private static EntityManager em = emf.createEntityManager();

    /**
     * Método principal que ejecuta el programa interactivo.
     */
    public static void main(String[] args) {
        // Scanner para leer la entrada del usuario desde la consola.
        Scanner scanner = new Scanner(System.in);

        // Variable de control para salir del bucle del menú interactivo.
        boolean exit = false;

        try {
            // Bucle principal para mostrar el menú y procesar opciones.
            while (!exit) {
                // Mostrar el menú de opciones al usuario.
                System.out.println("\n--- Menú ---");
                System.out.println("1. Añadir persona");
                System.out.println("2. Borrar Persona");
                System.out.println("3. Modificar Persona");
                System.out.println("4. Mostrar todas las Personas");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opción: ");

                // Leer la opción seleccionada por el usuario.
                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea sobrante tras leer un entero.

                // Ejecutar la acción correspondiente según la opción seleccionada.
                switch (option) {
                    case 1 -> aniadirPersona(scanner); // Llama al método para añadir una persona.
                    case 2 -> borrarPersona(scanner); // Llama al método para borrar una persona.
                    case 3 -> modificarPersona(scanner); // Llama al método para modificar una persona.
                    case 4 -> mostrarTodas(); // Llama al método para mostrar todas las personas.
                    case 5 -> exit = true; // Cambia la variable exit a true para salir del programa.
                    default -> System.out.println("Opción no válida."); // Muestra un mensaje para opciones inválidas.
                }
            }
        } catch (Exception e) {
            // En caso de error, se verifica si hay una transacción activa para deshacerla.
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir cualquier operación incompleta.
            }
        }

        // Cierra el gestor de entidades y la fábrica de gestores para liberar recursos.
        em.close();
        emf.close();
        // Cierra el Scanner para liberar recursos de entrada.
        scanner.close();
    }

    /**
     * Método para añadir una nueva persona a la base de datos.
     * Solicita al usuario los datos y los guarda en la base de datos.
     */
    private static void aniadirPersona(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine(); // Lee el nombre de la persona.

        System.out.print("Edad: ");
        int edad = scanner.nextInt(); // Lee la edad de la persona.
        scanner.nextLine(); // Consumir el salto de línea sobrante tras leer un entero.

        System.out.print("Email: ");
        String email = scanner.nextLine(); // Lee el email de la persona.

        // Crea una nueva instancia de Persona con los datos ingresados.
        Persona persona = new Persona(nombre, edad, email);

        // Inicia una transacción para persistir los datos en la base de datos.
        em.getTransaction().begin(); // Comienza la transacción.
        em.persist(persona); // Guarda la nueva persona en la base de datos.
        em.getTransaction().commit(); // Finaliza y confirma la transacción.

        System.out.println("Persona añadida!"); // Muestra un mensaje de éxito.
    }

    /**
     * Método para borrar una persona de la base de datos por su nombre.
     * Busca a la persona en la base de datos y la elimina si existe.
     */
    private static void borrarPersona(Scanner scanner) {
        System.out.print("Nombre de la persona a borrar: ");
        String nombre = scanner.nextLine(); // Lee el nombre de la persona a borrar.

        // Busca la persona en la base de datos utilizando su nombre como clave.
        Persona persona = em.find(Persona.class, nombre);

        if (persona != null) {
            // Si la persona existe, se procede a eliminarla.
            em.getTransaction().begin(); // Inicia una transacción.
            em.remove(persona); // Elimina la persona de la base de datos.
            em.getTransaction().commit(); // Finaliza y confirma la transacción.

            System.out.println("Persona borrada!"); // Muestra un mensaje de éxito.
        } else {
            // Si la persona no se encuentra, muestra un mensaje informativo.
            System.out.println("Persona no encontrada en la base de datos.");
        }
    }

    /**
     * Método para modificar los datos de una persona en la base de datos.
     * Permite al usuario actualizar la edad o el email de una persona existente.
     */
    private static void modificarPersona(Scanner scanner) {
        System.out.print("Nombre de la persona a modificar: ");
        String nombre = scanner.nextLine(); // Lee el nombre de la persona a modificar.

        // Busca la persona en la base de datos utilizando su nombre como clave.
        Persona persona = em.find(Persona.class, nombre);

        if (persona != null) {
            // Permite modificar la edad.
            System.out.print("Nueva edad (dejar en blanco si no se quiere modificar): ");
            String edadInput = scanner.nextLine(); // Lee la nueva edad (o deja en blanco para no modificar).
            if (!edadInput.isBlank()) {
                persona.setEdad(Integer.parseInt(edadInput)); // Actualiza la edad si se proporcionó un valor.
            }

            // Permite modificar el email.
            System.out.print("Nuevo email (dejar en blanco si no se quiere modificar): ");
            String emailInput = scanner.nextLine(); // Lee el nuevo email (o deja en blanco para no modificar).
            if (!emailInput.isBlank()) {
                persona.setEmail(emailInput); // Actualiza el email si se proporcionó un valor.
            }

            // Guarda los cambios en la base de datos.
            em.getTransaction().begin(); // Comienza una transacción.
            em.merge(persona); // Actualiza los datos de la persona.
            em.getTransaction().commit(); // Finaliza y confirma la transacción.

            System.out.println("Persona modificada!"); // Muestra un mensaje de éxito.
        } else {
            // Si la persona no se encuentra, muestra un mensaje informativo.
            System.out.println("Persona no encontrada.");
        }
    }

    /**
     * Método para mostrar todas las personas almacenadas en la base de datos.
     * Recupera y muestra todos los registros de personas.
     */
    private static void mostrarTodas() {
        // Consulta para obtener todas las personas de la base de datos.
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        List<Persona> personas = query.getResultList(); // Obtiene la lista de resultados.

        if (personas.isEmpty()) {
            // Si no hay personas en la base de datos, informa al usuario.
            System.out.println("No hay personas en la base de datos.");
        } else {
            // Si hay personas, las muestra una por una.
            personas.forEach(System.out::println);
        }
    }
}
