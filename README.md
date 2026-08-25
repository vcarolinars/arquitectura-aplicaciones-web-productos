# Arquitectura de Aplicaciones Web - CRUD Productos
Implementación de una arquitectura que permita desarrollar el backend de una aplicación web que implemente servicios API REST, 
con el fin de realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre una base de datos - PostgreSQL, utilizar un framework de desarrollo backend como Spring Boot que le permite estructurar adecuadamente el proyecto, aplicar buenas prácticas de desarrollo y asegurar una correcta comunicación entre el cliente y el servidor.

Backend RESTful desarrollado con Java 21 y Spring Boot.

## Tecnologías

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Docker
- Kubernetes
- AWS EC2

## Arquitectura
Este ejercicio implementa un Product Service organizado internamente mediante arquitectura en capas:

Controller -> Service -> Repository -> JPA/Hibernate -> PostgreSQL

La aplicación y PostgreSQL se despliegan en Kubernetes sobre una instancia AWS EC2.

## API REST

POST /api/productos

GET /api/productos

GET /api/productos/{id}

PUT /api/productos/{id}

DELETE /api/productos/{id}

## Manejo de errores

- 400 Bad Request para datos inválidos.
- 404 Not Found para productos inexistentes.
- 201 Created para creación de productos.
- 204 No Content para eliminación.

## Persistencia

PostgreSQL utiliza PersistentVolume y PersistentVolumeClaim en Kubernetes.

La tabla productos es gestionada mediante JPA/Hibernate sin SQL manual.

## Repositorio

Proyecto académico del módulo Arquitectura de Aplicaciones Web.
