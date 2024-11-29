# Acceso a Datos Act 1 Unidad 3

## Ecosistema de desarrollo

El IDE utilizado es **IntelliJ IDEA**, ejecutado en **Windows 11 Pro** con **JDK 17** (u otra versión compatible). El proyecto está configurado como un proyecto **Maven**, con las dependencias necesarias para trabajar con **ObjectDB** como motor de base de datos.

## Cómo ejecutar el proyecto

1. **Configuración de la base de datos:**
    - No es necesario configurar manualmente un archivo de base de datos. ObjectDB creará automáticamente el archivo `personas.odb` en la ruta definida dentro del proyecto al realizar una operación de persistencia.
    - Verifica que la carpeta donde se almacenará la base de datos (por ejemplo, `db`) exista o se cree automáticamente en el directorio del proyecto.

2. **Ejecución:**
    - Importa el proyecto en IntelliJ IDEA.
    - Asegúrate de que el archivo `objectdb.jar` esté configurado correctamente en el classpath del proyecto.
    - Ejecuta la clase `Main.java` desde el IDE para iniciar el programa interactivo.

3. **Dependencias Maven:**
    - El archivo `persistence.xml` contiene la configuración necesaria para trabajar con JPA y ObjectDB.

## Explicación del proyecto

Este es un proyecto desarrollado en Java que utiliza **ObjectDB** como motor de base de datos para gestionar información de personas. El objetivo principal del proyecto es realizar operaciones básicas de mantenimiento sobre una entidad `Persona` a través de un menú interactivo.

### **Estructura del proyecto**

- **Main.java:** Es el archivo principal que inicia la aplicación y gestiona la interacción con el usuario mediante un menú.
- **Persona.java:** Clase que representa la entidad `Persona` con atributos como `nombre`, `edad` y `email`. Está anotada como una entidad JPA para s