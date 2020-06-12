# Test technique : service de film

Merci de prendre le temps d'effectuer notre test technique *Backend java*. 
L'objectif de ce test est d'évaluer votre capacité à développer un service de films.

Vous pouvez utiliser le framework et les libs de votre choix tant que vous codez en **Java**.

Ce test devrait vous prendre environ 2h. Passez le temps que vous voulez, n'hésitez pas à ajouter des méthodes vides commentées si vous manquez de temps.


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

1. poster le fichier `films.json` et garder les films en mémoire
2. retourner le nombre de film par genre correspondant à une recherche sur le nom du film passé en paramètre (ex : star)


## Industrialiser

Utiliser maintenant l'API [OMDBAPI](https://www.omdbapi.com/) pour les nouveaux endpoints suivants :

3. retourner les films correspondant à une année et à un nom passé en paramètre
4. retourner le détail d'un film en utilisant un `imdbID` passé en paramètre

## Test

Nous aimerions voir quelques tests unitaires dans le code correspondant au endpoint 2.


## Livraison

Lorsque votre code est fini, veuillez :
1. Documenter le déploiement de votre solution dans un markdown nommé `DEPLOY.md` 
2. Pousser votre code sur gitlab.com
3. Envoyer un mail pour nous prévenir que le code est livré
