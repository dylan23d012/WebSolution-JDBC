# WebSolution JDBC

## Descripción

WebSolution JDBC es un módulo de software desarrollado en Java para la gestión interna de una empresa dedicada al diseño y desarrollo de páginas web.

El proyecto implementa una conexión con una base de datos MySQL mediante JDBC y permite realizar operaciones CRUD (Crear, Consultar, Actualizar y Eliminar) sobre diferentes módulos del sistema.

Este desarrollo corresponde a la evidencia **GA7-220501096-AA2-EV01 — Codificación de módulos del software**, del componente formativo **CF20 — Java con JDBC**.

## Tecnologías utilizadas

* Java 8
* JDBC
* MySQL
* Maven
* Git
* GitHub
* Visual Studio Code

## Módulos desarrollados

El proyecto cuenta con los siguientes módulos:

* Clientes
* Proyectos
* Servicios
* Tareas

## Funcionalidades CRUD

Cada módulo implementa operaciones de persistencia utilizando JDBC:

### Clientes

* Inserción de clientes.
* Consulta de clientes.
* Actualización de clientes.
* Eliminación de clientes.

### Proyectos

* Inserción de proyectos.
* Consulta de proyectos.
* Actualización de proyectos.
* Eliminación de proyectos.

### Servicios

* Inserción de servicios.
* Consulta de servicios.
* Actualización de servicios.
* Eliminación de servicios.

### Tareas

* Inserción de tareas.
* Consulta de tareas.
* Actualización de tareas.
* Eliminación de tareas.

Las tareas mantienen una relación con los proyectos mediante el campo `id_proyecto`, permitiendo consultar el proyecto asociado a cada tarea.

## Estructura del proyecto

```text
websolution-jdbc/
│
├── pom.xml
├── .gitignore
├── README.md
│
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── websolution/
    │               ├── App.java
    │               ├── Cliente.java
    │               ├── ClienteDAO.java
    │               ├── Conexion.java
    │               ├── Proyecto.java
    │               ├── ProyectoDAO.java
    │               ├── Servicio.java
    │               ├── ServicioDAO.java
    │               ├── Tarea.java
    │               └── TareaDAO.java
    │
    └── test/
        └── java/
            └── com/
                └── websolution/
                    └── AppTest.java
```

## Conexión a la base de datos

El proyecto utiliza JDBC para establecer la comunicación entre Java y MySQL.

La base de datos utilizada es:

```text
websolution
```

La conexión se realiza mediante el controlador JDBC de MySQL y permite ejecutar instrucciones SQL utilizando `Connection`, `PreparedStatement` y `ResultSet`.

## Estándares de codificación

Se aplican convenciones de nomenclatura para facilitar la lectura y mantenimiento del código:

* **Clases:** PascalCase.
* **Métodos:** camelCase.
* **Variables:** camelCase.
* **Paquetes:** nombres en minúscula.
* **Constantes:** MAYÚSCULAS cuando corresponde.

Ejemplos:

```text
ClienteDAO
ProyectoDAO
ServicioDAO
TareaDAO

insertarCliente()
listarProyectos()
actualizarServicio()
eliminarTarea()
```

## Versionamiento

El proyecto utiliza Git como herramienta de control de versiones y GitHub como repositorio remoto.

Repositorio:

https://github.com/dylan23d012/WebSolution-JDBC

Commit inicial:

```text
Codificacion modulo Java JDBC
```

La rama utilizada actualmente es:

```text
master
```

## Pruebas realizadas

Se realizaron pruebas de las operaciones CRUD mediante la ejecución del proyecto con Maven.

Comando utilizado para compilar:

```text
mvn clean compile
```

Comando utilizado para ejecutar:

```text
mvn exec:java "-Dexec.mainClass=com.websolution.App"
```

Las pruebas permitieron verificar:

* Conexión con MySQL.
* Consulta de registros.
* Inserción de nuevos registros.
* Actualización de registros existentes.
* Eliminación de registros.
* Relación entre tareas y proyectos.

## Evidencia de funcionamiento

Durante las pruebas se verificó el funcionamiento de los módulos de Clientes, Proyectos, Servicios y Tareas.

En el módulo de Tareas se comprobó la relación con el módulo de Proyectos, mostrando el nombre del proyecto asociado a cada tarea.

En el módulo de Servicios se comprobó la ejecución completa del CRUD mediante las operaciones de creación, consulta, actualización y eliminación.

## Evidencia

**GA7-220501096-AA2-EV01**

**Codificación de módulos del software**

**CF20 — Java con JDBC**

Proyecto: **WebSolution JDBC**
