# Java Spring API 
Exemplo de API RESTFUL com uso do Java Spring, JPA, Hibernate e PostgreSQL.

This project was generated with [Java Spring Boot](https://spring.io/projects/spring-boot) version 2.6.1

## Development server

Navigate to `http://localhost:8080/api/cursos`. The app will automatically reload if you change any of the source files.

## API REQUESTS: 

# List course
GET (json) -> return (json)
`http://localhost:8080/api/cursos/list`

# Get course by id
GET (id = 1) -> return (json)
`http://localhost:8080/api/cursos/1`

# Save course 
POST and PUT (json) -> return (json)
`http://localhost:8080/api/cursos/save`

# Delete course
DELETE (json) -> return boolean
`http://localhost:8080/api/cursos/delete`

## Build

The build artifacts will be stored in the `target/` directory.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
