# Acceso a datos U 5 Act 3

# Ecosistema de desarrollo

El IDE utilizado es IntelIJ edición Ultimate, Windows 11 pro, jdk 23 y sus librerias correspondiantes.

# Como ejecutar el proyecto

Para poder ejecutar este proyecto es necesario tener una conexión con mongodb, preferiblemente con los elementos añadidos anteriormente para poder ejecutar correctamente el proyecto. En caso de hacer con su propia base de datos se deberian cambiar las siguientes lineas

`
private static final String DATABASE_NAME = "practica_java";
private static final String COLLECTION_NAME = "elements";
private static final String MONGO_URI = "mongodb://localhost:27017/";
`

# Explicación del proyecto

Este proyecto debe ser capaz de conectarse a la base de datos de mongoDB y pasar los archivos json introducidos anteriormente a XML e imprimirlos por consola.