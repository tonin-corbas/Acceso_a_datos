# Acceso_a_datos

Este proyecto se ha realizado en Intel IJ, con Windows 11 Pro y JDK 23 con sus respectivas librerias.

En este ejercicio, se pide que mediante el uso de java IO de manera básica copiemos un archivo y despues intentemos volverlo a copiar pero al archivo original se le quitaran permisos de escritura para que así el catch salte y que el círculo se cierre.

En este caso lo que hace el programa primero es crear la variable del archivo que nos sirve para todo el proceso. Cuando ya está creado el programa procede a comprobar mediante un constructor dentro de la clase File que le servirá para distiguir el archivo entre un documento de texto o un archivo binario (jpg).

En la clase File tambien se encuentra el constructor que sirve para revocar el permiso de escritura del archivo. Empezando por el constructor para comprobar el tipo de archivo se llama #isBinaryFile, lo que hace es a apartir de un InputStream lee los primeros 1024 bytes del archivo, la cantidad que haya leido se guarda en una variable que nos servirá para saber si es tipo texto o si es binario, ya que si no detecta ni un solo byte se puede asumir que es uno de tipo texto y devolverá false. Por otro lado si se detecta algún byte se comenzará a leer el byte por byte.

El segundo constructor se usa para quitar los permisos de escritura sobre el archivo original ya sea de texto o binario.

Una vez verificado el tipo de archivo que es, se procede a ejecutar las clases de lectura y escritura. En caso de que se de tipo texto se emplearán las clases AccesFileReader43483430K y AccesFileWriter43483430K que dichas clases por medio de de un try/catch pasa linea por linea para primero leer el archivo y despues copiarlo en otro nuevo usando un while y las funciones de RandomAccesFile.

En caso de que sea un archivo binario se usarán las clases llamadas FileInputStream43483430K y FileOutputStream43483430K en las que se dedica a ir byte por byte del archivo para que de esa forma en el outputStream sea capaz de copiar el archivo.

Despues de pasar esos pasos se procede a quitar los permisos de escritura del archivo original y se procede a intentar volver a copiarlo.

Nota: se ha colocado al final del código una linea que hace que una vez se finalice todo el círculo los permisos de escritura vuelva a estar en true.

Para la correcta utilización del programa se deberá colocar en el main linea 7 el path del archivo correspondiente