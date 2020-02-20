# Test technique : service de film

Merci de prendre le temps d'effectuer notre test technique *Backend java*. 
L'objectif de ce test est d'évaluer votre capacité à développer un service de films.

Vous pouvez utiliser le framework et les libs de votre choix tant que vous codez en **Java**.

Ce test devrait vous prendre environ 1h30. Passez le temps que vous voulez, n'hésitez pas à ajouter des méthodes vides commentées si vous manquez de temps.


## Créer le service

Nous souhaitons créer une API RESTFUL qui manipule des films stockés en json dans le fichier [*films.json*](./films.json) :

```json
{
    "films": [
        { 
            "Title":"Star Wars: Episode IV - A New Hope",
            "Year":"1977",
            "Genre":"Action, Adventure, Fantasy, Sci-Fi",
            "Type":"serie"
         },
         { 
            "Title":"Star Wars: Episode V - The Empire Strikes Back",
            "Year":"1980",
            "Genre":"Action, Adventure, Fantasy, Sci-Fi",
            "Type":"movie"
         }
         ...
    ],
    "total": "10"
}
```

Créer les endpoints suivants :
1. retourner les films d'un réalisateur correspondant à une recherche passée en paramètre (ex : star)
2. retourner une liste de tous les genres avec 2 films au hasard par genre (aucun paramètre en entrée)


## Industrialiser

Utiliser maintenant l'API [OMDBAPI](https://www.omdbapi.com/) pour les nouveaux endpoints suivants :
1. retourner les films correspondant à une année et à un nom passé en paramètre
2. retourner le détail d'un film en utilisant un des `imdbID` renvoyés par l'appel précédent

## Test

Nous aimerions voir quelques tests unitaires dans le code livré sur le service retournant une liste de tous les genres avec 2 films par genre.


## Livraison

Lorsque votre code est fini, veuillez :
1. Documenter le déploiement de votre solution dans un markdown nommé DEPLOY.md 
2. Pousser votre code sur gitlab **XXX**
3. Envoyer un mail pour nous prévenir que le code est *livré*
