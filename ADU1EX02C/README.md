# Acceso a datos Act 2.3

# Ecosistema de desarrollo

El IDE utilizado es IntelIJ, Windows 11 pro, jdk 23 y sus librerias correspondiantes.

# Como ejecutar el proyecto

se debe colocar el path absoluto del archivo xml para el correcto funcionamiento del proyecto en la variable llamada archivoXML ubicado en el main.

# Explicación del proyecto

Lo que debe hacer el proyecto es la lectura de archivos XML con DOM. En mi proyecto dividido en 3 clases: Main, Libro y SAXHandler. En el main se crea el parser para procesar el archivo xml y obtener la lista de libros a partir de dicho archivo.

En la clase libro se hace el contructor de Libro con sus getters y setters. Además de generar el shout que pinta todo el texto.

Finalmente la clase Libros, en esta clase se pasa las etiquetas de los libros.