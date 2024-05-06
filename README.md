# Documentación de API y Acceso a Base de Datos

## Descripción General


## Acceso a Swagger UI

Puedes visualizar y probar la API de la aplicación accediendo a la interfaz de usuario de Swagger. Esta interfaz permite una fácil interacción con todos los endpoints de la API desde el navegador.

```
http://localhost:8092/swagger-ui.html
```
La aplicación utiliza la base de datos llamada `clientes`, y a continuación se muestra cómo puedes realizar consultas directamente para obtener datos.

### Ejemplo de Consulta SQL


Configura el  properties
```
#Config base de datos
Spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
Spring.datasource.username=root
Spring.datasource.password=1234
Spring.datasource.url=jdbc:mysql://localhost/db_springboot_dev?useSSL=false
```
Si necesitas obtener todos los registros de la tabla `clientes`, puedes usar la siguiente consulta SQL:
```
create database db_springboot_dev;
CREATE TABLE `db_springboot_dev`.`clientes` (
  `id_cliente` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `fecha_registro` date  NOT NULL,
  PRIMARY KEY (`id_cliente`));
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Joel', 'Jurado', 'juradoec@yahoo.com', '2023-08-01');
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Carlos', 'Miranda', 'mirandaTr98@gmail.com', '2023-08-02');
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Marcela', 'Sanchez', 'schMarce@itb.com', '2023-08-03');
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Ben', 'Tennyson', 'ben10@cn.com', '2023-08-04');
INSERT INTO db_springboot_dev.clientes (nombre, apellido, correo, fecha_registro) VALUES('Ben', 'Tennyson', 'ben10@cn.com', '2023-08-04');

```

```sql
SELECT * FROM clientes;


