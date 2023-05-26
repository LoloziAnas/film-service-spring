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
git clone https://gitlab.com/digimind-public/technical-tests/candidates/anas-lolozi.git
```

2- Accédez au répertoire du projet.

```
cd film-service
```

3- Vérifiez que la configuration de la base de données H2 est correcte dans le fichier **application.properties.** Assurez-vous que les propriétés suivantes sont définies :

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

4- Compilez et construisez l'application en utilisant Maven

```agsl
mvn clean install
mvn package
```

5- Exécutez l'application Spring Boot.

```agsl
mvn spring-boot:run
```

L'application sera lancée sur http://localhost:8081

6- Accédez à la console H2 pour vérifier et manipuler les données.

Ouvrez votre navigateur et accédez à http://localhost:8081/h2-console. Utilisez les paramètres de connexion suivants :

* JDBC URL: jdbc:h2:mem:testdb
* User Name: sa
* Password: (laissez le champ vide)

Une fois connecté, vous pouvez exécuter des requêtes SQL et vérifier les données de la base de données.

7- Testez les différents endpoints de l'API en utilisant un outil tel que Postman ou en accédant directement aux URL appropriées.


* Recherche de films par genre :
```curl
GET http://localhost:8081/films?genre=Action
```

* Recherche de films par année et titre :
```curl
GET http://localhost:8081/films/search?year=2022&title=Star
```

* Obtention des détails d'un film par IMDb ID :

```curl
GET http://localhost:8081/films/tt3896198
```
* Ajouter un nouveau film a la base de donnees
```curl
curl -H 'Content-Type: application/json' \
      -d '{"title": "Test","year": 2014,"genre": "Test","type": "Test"}' \
      -X POST \
      http://localhost:8081/films
```

### Documentation swagger
Accédez à la documentation swagger a travers le lien suivant
```
http://localhost:8081/swagger-ui/index.html
http://localhost:8081/v3/api-docs
```




