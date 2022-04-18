# PruebaBackEndMpos

Instalación local

Prueba BackEnd desarrollada en java en la version 8 y springboot en su version 2.1.3 con sts(spring tool suite)

Base de datos: Sql Server 2019


Clone
--------

```sh
git clone https://github.com/JamiltonQuintero/PruebaBackEndMpos
```

Run
--------

Para ejecutar el proyecto sin inconvenientes debes realizar los sigueointes pasos:
1 - Ejecutar Los scrips de base de datos Sql Server 1. Create DataBse 2. CreateTables and Scrips
2 - Ingresar a la raiz del proyecto y modificar el archivo env-variables con las credenciales de tu base de datos Sql Server.
3 - Si no tienes habilidato el puerto 1433 por favor sigue estos pasos:
```sh
https://es.stackoverflow.com/questions/90868/c%C3%B3mo-habilitar-el-puerto-1433-de-sql-server-2014-en-windows-10
```
4 - Ejecuta los sigueinjetes comandos:

```sh
./mvn clean install -U
```

```sh
./mvnw spring-boot:run
```

Access
--------

Pruebas con postman
```
https://app.getpostman.com/join-team?invite_code=7a1a26d7b813238df5c5f96e623283c0&target_code=aeff1615f22e3f437219b9c67865b75a
```

```
http://localhost:8080
```