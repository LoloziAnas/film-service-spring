# Guide de déploiement de la solution
Ce document fournit des instructions pour déployer la solution du service de films développée avec Java, Spring Boot, H2 et Spring Data JPA, en utilisant GitLab et les dépendances spécifiées.

* The original package name 'com.digimind.film-service' is invalid and this project uses 'com.digimind.filmservice' instead.

# Prérequis

Avant de commencer le déploiement, assurez-vous d'avoir les éléments suivants installés sur votre système :

* Java Development Kit (JDK) version 8 ou supérieure
* Maven ou Gradle
* Git
### Étapes de déploiement
Suivez les étapes ci-dessous pour déployer la solution :

1- Clonez le dépôt GitLab contenant le code source de la solution.

```
git clone <URL_DU_DÉPÔT>
```

2- Accédez au répertoire du projet.

```
cd film-service
```

3- Vérifiez que la configuration de la base de données H2 est correcte dans le fichier **application.properties.** Assurez-vous que les propriétés suivantes sont définies :

```agsl
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)






