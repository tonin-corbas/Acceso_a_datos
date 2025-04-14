# Acceso a datos U 6 Act 1

# Ecosistema de desarrollo

El IDE utilizado es IntelIJ edición Ultimate, Windows 11 pro, jdk 23 y sus librerias correspondiantes.

# Como ejecutar el proyecto

Para poder ejecutar el proyecto es necesario el siguiente trozo de codigo rn un archivo llamado application.properties

`spring.datasource.url=jdbc:sqlite:ADU6EX01JAKC/database.sqlite
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081
server.address=0.0.0.0`
# Explicación del proyecto

Este proyecto debe ser capaz de iniciar la base de datos y la api usando spring y usando endpoints en postman ser capaz de hacer llamadas a la base de datos