# 馃彣 PSC Hotel 馃彣

![java ci workflow](https://github.com/kevin31000/pscHotel/actions/workflows/java-ci.yml/badge.svg) [![codecov](https://codecov.io/gh/kevin31000/pscHotel/branch/main/graph/badge.svg?token=VI1939UJ2S)](https://codecov.io/gh/kevin31000/pscHotel)

PSC Hotel es una aplicaci贸n de reservas de hotel mediante la cual los clientes, haciendo uso de su 
cuenta de usuario, podr谩n realizar reservas de las habitaciones en las fechas deseadas.


## 馃搵 Pre-requisitos 馃搵

Para la ejecuci贸n de PSC Hotel es necesario tener los siguientes programas correctamente instalados y 
configurados:

* [Java JDK 8]         (https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
* [Apache Maven (bin)] (https://maven.apache.org/download.cgi)
* [XAMPP]              (https://www.apachefriends.org/es/index.html)
  (Alternativamente tambi茅n es posible usar):  
  [MySQL Workbench]    (https://dev.mysql.com/downloads/workbench/)


### 馃殌 Comenzando 馃殌

Para obtener una copia local del proyecto en funcionamiento para prop贸sitos de desarrollo y pruebas 
es necesario descargarse este repositorio e importarlo a un IDE de programaci贸n compatible con los requisitos previamente nombrados.

https://github.com/kevin31000/pscHotel.git


### 馃敡 Instalaci贸n y ejecuci贸n 馃敡

El primer paso ser谩 abrir nuesta herramienta de base de datos como "XAMPP" o "MySQL Workbench" y ejecutar el archivo que aparece en la carpeta src/main/sql con un usuario root. De esta manera, crearemos el esqueleto de la base de datos del proyecto.

Para la ejecuci贸n del proyecto es necesario abrir dos instancias del "cmd"(S铆mbolo del sistema) y ejecutar los siguientes comandos sin cerrar en ning煤n momento ambas instancias:
 
Para ejecutar el servidor:

* "mvn clean" 
* "mvn compile"
* "mvn datanucleus:enhance" (Este comando solo es necesario realizarlo la primera vez que se realiza este proceso)
* "mvn datanucleus:schema-create" (Este comando solo es necesario realizarlo la primera vez que se realiza este proceso, sirve para crear las tablas en la BD)
* "mvn exec:java -PServer"

Para ejecutar el cliente, en la otra instancia del cmd:

* "mvn exec:java -PClient"


### 馃敡 Test y documentaci贸n 馃敡

En caso de querer construir el proyecto y comprobar los tests unitarios el comando a utilizar desde la consola ser谩:

* "mvn test" (antes de ejecutar el comando es importante haber ejecutado primero el servidor en otra consola para que las pruebas unitarias se lancen correctamente)

Por otro lado, en caso de querer obtener la documentaci贸n y an谩lisis del proyecto, se deber谩 ejecutar el siguiente comando:

* "mvn site" (antes de ejecutar el comando es importante haber ejecutado primero el servidor en otra consola para que las pruebas unitarias se lancen correctamente)


### 馃摝 Datos de prueba 馃摝

Para poder probar el proyecto existen clientes, habitaciones y reservas de prueba las cuales al arrancar el servidor ya aparecen en la base de datos.

Existen un total de 16 habitaciones ya creadas, 2 reservas y 2 usuarios de prueba; un usuario cliente, y otro de administrador. 

Estas son las cuentas de prueba en caso de querer iniciar sesion como cliente o como administrador:

Cliente --> email: test@test.es password: test

Administrador --> email: admin@admin.es password: admin

Por otro lado, en caso de querer crear otra cuenta de cliente desde el cliente ya es posible mediante el registro.


### 馃洜锔? Construido con 馃洜锔?

A continuaci贸n se detallan las herramientas utilizadas para crear el proyecto:

* [Eclipse]      (https://www.eclipse.org/) - Entorno de desarrollo de software 
* [Apache Maven] (https://maven.apache.org/) - Manejador de dependencias
* [Log4j]        (http://logging.apache.org/log4j/1.2/) - Logger


### 鉁掞笍 Autores 鉁掞笍

* [Kevin Arnaiz] (https://github.com/kevin31000/pscHotel)
* [Jaime Amann]  (https://github.com/QuimiJ)
* [Mikel Castro] (https://github.com/MikelCastroNieva)
* [Sergio L贸pez] (https://github.com/Sergiolo99)
* [Jon Soler]    (https://github.com/JonSoler)

Tambi茅n puedes consultar la lista de todos los contribuyentes en GitHub:
https://github.com/kevin31000/pscHotel 


### 鈩癸笍 Versi贸n 鈩癸笍

PSC Hotel漏 ver. 3.0 - 2021-05-20


