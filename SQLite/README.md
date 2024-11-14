# Acceso a datos Act 3 Unidad 2

# Ecosistema de desarrollo

El IDE utilizado es IntelIJ, Windows 11 pro, jdk 23,proyecto hecho en maven y sus librerias correspondiantes de jdbc.

# Como ejecutar el proyecto

se debe colocar el path absoluto de la base de datos para el correcto funcionamiento del proyecto en la variable llamada **DB_URL** ubicado en la clase **Datos** y además si se está haciendo las pruebas en Intel IJ se debe colocar el archivo de la base de datos en la carpeta llamada resources, ubicado en **src/main/resources**.

# Explicación del proyecto

Este es un proyecto hecho en Java que utiliza Maven y una base de datos SQLite para gestionar información de empleados de una empresa.

**Estructura del proyeto**

**Main.java:** Archivo principal que inicia la aplicación y gestiona la interacción con el usuario

**Datos.java:** Clase para gestionar la conexión con la base de datos y las operaciones de eliminación.

**empresa.db:** Archivo de base de datos SQLite que contiene la información de los empleados.

# Funcionalidades

1. Agregar empleados a la base de datos: Permite ingresar los datos de un nuevo empleado en la base de datos.
2. Leer empleados en la BBDD: Pinta por pantalla todos los empleados almacenados en la base de datos.
3. Eliminar empleados: Permite eliminar un empleado de la base de datos usando el id del empleado como identificador principal para poder eliminarlos, **Solo se puede elimminar un usuario a la vez**.