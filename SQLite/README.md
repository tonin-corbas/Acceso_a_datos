# Acceso a datos Act 2.2

# Ecosistema de desarrollo

El IDE utilizado es IntelIJ, Windows 11 pro, jdk 23,proyecto hecho en maven y sus librerias correspondiantes de jdbc.

# Como ejecutar el proyecto

se debe colocar el path absoluto de la base de datos para el correcto funcionamiento del proyecto en la variable llamada **DB_URL** ubicado en la clase **Datos** y además si se está haciendo las pruebas en Intel IJ se debe colocar el archivo de la base de datos en la carpeta llamada resources.

# Explicación del proyecto

Este es un proyecto hecho en Java que utiliza Maven y una base de datos SQLite para gestionar información de empleados de una empresa.

**Estructura del proyeto**

**Main.java:** Archivo principal que inicia la aplicación y gestiona la interacción con el usuario

**Datos.java:** Clase encargada de la conexión y las operaciones básicas con la base de datos. Incluye métodos para acceder y manipular los datos almacenados en empresa.db.

**empresa.db:** Archivo de base de datos SQLite que contiene la información de los empleados.