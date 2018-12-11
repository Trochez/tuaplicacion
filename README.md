# tuaplicacion

Juan Diego Tróchez Montoya.

prueba para tuaplicacion

Este repositorio corresponde al desarrollo de las pruebas requeridas para hacer parte del equipo de Tuaplicacion.

En este repositorio se encuentran dos carpetas:

1 - tuaplicacion_mobile: En esta carpeta se encuentra el archivo **_app-debug.apk_** debug el cual puede ser cargado a un dispositivo android para instalar la aplicación desarrollada. También se encuentra la carpeta **_tuaplicacion/_** que corresponde al proyecto desarrollado en Android studio, este proyecto puede ser cargado desde el IDE de Android studio.

2 - tuapp_backend: En esta carpeta se encuentra el archivo **_tuapp.sql_** el cual describe la estructura de la base de datos MySql para la cual se realiza el desarrollo. El usuario de base de datos debe ser **_root_** y la contraseña **_1234_** . Dentro de esta carpeta también se encuentra la carpeta **_tuapp/_** la cual corresponde al proyecto desarrollado en el IDE de JetBrains, este proyecto puede ser abierto desde la mayoria de IDEs java.

En los próximos días se desplegará el desarrollo backend en una ip pública. Este documento será actualizado con dicha ip después de ralizar dicho despliegue. El despliegue se realiza en un servidor Ubuntu-Glassfish.


# Descripción

## Front end.

El proyecto frontend es una app desarrollada en Android Studio. Esta app consta de dos vistas: La vista inicial es una lista de usuarios en donde cada item se compone de dos líneas, la primera con los nombres y apellidos y la segunda con el email del usuario.

Al seleccionar uno de los items de usuario, se abre la otra vista, esta vista se compone de un campo imagen donde se carga la imagen del usuario desde un url, un campo nombre donde se carga el titula de la persona, el nombre y el apellido, un campo telefóno y un campo dirección donde se carga el estado, la ciudad y la calle donde vive el usuario.

Cada una de las vistas consume los servicios especificados, la respuesta de estos servicios es capturada en un String el cual es procesado como objeto JSON para definir objetos que representan usuarios en el caso de la vista principal y usuarion con información especifica en el caso de la segunda vista.


## Back end

El proyecto bakcend es una serie de servicios java utilizando peticiones get (consulta), post (inserción), put (actualización) y delete (eliminación) para interactuar con dos tipos de datos: infomración básica e información adicional.

Para cada tipo de información se desarrolla un controlador y una clase que lo representa. 

La información básica y adicional se representan en una serie de clases e interfaces distintos pero equivalentes para realizar las operaciones necesarias en la base de datos (insert,update, delete y select). Los archivos correspondientes a la información básica se encuentran en un paquete independiente al igual que los archivos de la información adicional, estos dos paquetes se encuentran dentro del paquete donde estan los controladores de cada tipo de información.

Para la información básica se realizan desarrollos adicionales: se desarrolla un servicio para obtener todos los registros de información básica buscando generar una lista de usuarios y un método de consulta mediante email para verificar que un nuevo email no esté registrado.

### End points

#### Información Básica

/createBasic  (Inserción de registro de información básica entregando como parámetros los campos email, name, lastName, tel y address)

/findBasic  (Busqueda de registro de información básica a partir del id del registro)

/getAllBasic  (Obtención de todos los registros de información básica)

/delete/{id}  (Eliminación de registro de información básica entregando el id del resgitro como parámetro)

/put/{id}  (Actualización de registro de información básica entregando el id y la información del registro en forma de String JSON como parámetros)


#### Información adicional

/createAditional  (Inserción de registro de infromación adicional entregando como parámetros los campos art, music, movies y basicid donde basicid es el id del registro de información básica a la cual se asocia el registro de información adicional que se está insertando)

/findAditional  (Busqueda de registro de información adicional a partir del id del registro)

/deleteAditional/{basicid}  (Eliminación de registro de información adicional entregando el campo basicid como parametro para identificar el registro a eliminar)

/putAditional/{basicid}  (Actualización de registro de información adicional entregando el campo basicid y la información del registro en forma de String JSON como parámetros)


Espero que este documento sea claro, sin embargo, estaré pendiente para atender cualquier solicitud con amabilidad.

