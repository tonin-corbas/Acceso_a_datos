# Acceso a datos U 4 Act 2

# Ecosistema de desarrollo

El IDE utilizado es IntelIJ edición Ultimate, Windows 11 pro, jdk 23 y sus librerias correspondiantes.

# Como ejecutar el proyecto

se debe crear la conexion con la base de datos de MySQL utilizando la siguiente ruta **jdbc:mysql://127.0.0.2:3306/adu4ex02jakc** siendo la ip del servidor + / +el nombre de la base de datos a la que te quieres conectar. Cuando se esté configurando la base de datos en el apartado de Database si se presiona ctrl + barra espaciadora aparecerán las bases de datos posibles para hecer conexión. Tambien se deberán de cambiar la url, usuario y contraseña del Main y el hibernte.cfg.xml en las siguientes zonas:

Main:

`private static final String DB_URL = "jdbc:mysql://adu4ex02jakc";`
`private static final String DB_NAME = "adu4ex02jakc";`
`private static final String DB_USER = "root";`
`private static final String DB_PASSWORD = "root";`

hibernate.cfg.xml:

`<property name="hibernate.connection.url">jdbc:mysql://127.0.0.2:3306/adu4ex02jakc</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">Madrid12</property>`

**IMPORTANTE**

Si se generan las clases a partir de la base de datos hay que añadir manualmente la siguiente linea: **@GeneratedValue(strategy = GenerationType.IDENTITY)** en el caso en que el id sea autoincremental ya que hibernate por defecto no suele configurar dicha linea a no ser que se especifique en el hibernate.reveng.xml. Una vez añadida la linea @GeneratedValue(strategy = GenerationType.IDENTITY) ya funcionará correctamente

# Explicación del proyecto

Este proyecto lo que hace es que al conectarse a la base de datos y generado las clases te permite añadir autores y libros, así como tambien te permite listarlos para poder ver los autores y libros que hay en la base de datos, también permite eliminar los autores y libros.
