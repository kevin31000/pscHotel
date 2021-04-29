# 🏨 PSC Hotel 🏨
------------------------------------------------------------------------------------------------------

PSC Hotel es una aplicación de reservas de hotel mediante la cual los clientes, haciendo uso de su 
cuenta de usuario, podrán realizar reservas de las habitaciones en las fechas deseadas.


## 📋 Pre-requisitos 📋
------------------------------------------------------------------------------------------------------

Para la ejecución de PSC Hotel es necesario tener los siguientes programas correctamente instalados y 
configurados:

* [Java JDK 8]         (https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
* [Apache Maven (bin)] (https://maven.apache.org/download.cgi)
* [XAMPP]              (https://www.apachefriends.org/es/index.html)
  (Alternativamente también es posible usar):  
  [MySQL Workbench]    (https://dev.mysql.com/downloads/workbench/)


### 🚀 Comenzando 🚀
------------------------------------------------------------------------------------------------------

Para obtener una copia local del proyecto en funcionamiento para propósitos de desarrollo y pruebas 
es necesario descargarse este repositorio e importarlo a un IDE de programación compatible con los requisitos previamente nombrados.
```
https://github.com/kevin31000/pscHotel.git
```


### 🔧 Instalación y ejecución 🔧
------------------------------------------------------------------------------------------------------

Una vez obtenida la copia de PSC Hotel debemos importarla al entorno de desarrollo que estemos usando. 
El primer paso será abrir nuesta herramienta de base de datos como "XAMPP" o "MySQL Workbench" y ejecutar el archivo que aparece en la carpeta src/main/sql con un usuario root. De esta manera, crearemos el esqueleto de la base de datos del proyecto.

Para la ejecución del proyecto es necesario abrir dos instancias del "cmd"(Símbolo del sistema) y ejecutar los siguientes comandos sin cerrar en ningún momento ambas instancias:
 
Para ejecutar el servidor:
```
* "mvn clean" 
* "mvn compile"
* "mvn datanucleus:schema-create" (Este comando solo es necesario realizarlo la primera vez que se realiza este proceso, sirve para crear la tablas en BD)
* "mvn exec:java -PServer"
```

Para ejecutar el cliente, en la otra instancia del cmd:
```
* "mvn exec:java -PClient"
```
### 🔧 Test y documentación 🔧
------------------------------------------------------------------------------------------------------
En caso de querer comprobar los test del proyecto, primero habrá que ejecutar el servidor y posteriormente usar el siguiente comando desde la consola:
```
* "mvn test"
```
Por otro lado, en caso de querer obtener la documentación del proyecto ejecutar el siguiente comando despues de ejecutar el servidor:
```
* mvn site
```
### 📦 Datos de prueba 📦
------------------------------------------------------------------------------------------------------
Para poder probar el proyecyo existen datos clientes y habitaciones de prueba las cuales al arrancar el servidor ya aparecen en la base de datos.

Existen un total de 16 habitaciones ya creadas y 2 usuarios de prueba, un cuenta de cliente, y otra de administrador. 

Estas son las cuentas de prueba en caso de querer iniciar sesion como cliente o como administrador:
```
Cliente --> email: test@test.es password: test
Administrador --> email: admin@admin.es password: admin
```

### 🛠️ Construido con 🛠️
------------------------------------------------------------------------------------------------------

A continuación se detallan las herramientas utilizadas para crear el proyecto:

* [Eclipse]      (https://www.eclipse.org/) - Entorno de desarrollo de software 
* [Apache Maven] (https://maven.apache.org/) - Manejador de dependencias
* [Log4j]        (http://logging.apache.org/log4j/1.2/) - Logger


### ✒️ Autores ✒️
------------------------------------------------------------------------------------------------------

* [Kevin Arnaiz] (https://github.com/kevin31000/pscHotel)
* [Jaime Amann]  (https://github.com/QuimiJ)
* [Mikel Castro] (https://github.com/MikelCastroNieva)
* [Sergio López] (https://github.com/Sergiolo99)
* [Jon Soler]    (https://github.com/JonSoler)

También puedes consultar la lista de todos los contribuyentes en GitHub:
https://github.com/kevin31000/pscHotel 


### ℹ️ Versión ℹ️
------------------------------------------------------------------------------------------------------
PSC Hotel© ver. 1.0 - 2020-04-05
https://github.com/kevin31000/pscHotel

