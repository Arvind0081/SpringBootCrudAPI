# Getting Started

 * install jdk in system
 * Set Java_Home environment variable in system's advance settings
 * Add Spring Boot Extension Pack in vs code
 * Add Extension Pack for Java by microsoft
 * to create project open Command Palette (ctrl + shift +p)
 * Select Spring Initializr:Create a Maven Project
 * Select Spring boot version
 * Select Project Language-Java
 * Enter Group Id com.organizationname
 * Enter Artifact Id (Project Name)
 * Select Packaging type -Jar (Java Archive)
 * Select Java version
 * Select dependencies
 - Spring Web -> to create RESTFul API
 - MySQL Driver -> to connect with database
 - Spring Data JPA ->  Hibernate ,DAO layer/ send receive data from database/repository
 - H2 Database -> Relational datbase
 - Lombok -> developers tool ,reduce boilerplate code 
 
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.2/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.2/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

