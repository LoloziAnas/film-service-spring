```graphql
query{
    allFilms{
        id, title
    }
}
```
```graphql
query{
    filmById(id:1){
        title, type
    }
}
```
```graphql
mutation{
  saveFilm(filmRequest: {title:"title", genre: "action", type:"movie", fYear:1994 }){
    id,title
  }
}
```
```graphql
mutation{
  saveFilm(filmRequest: {title:"title", genre: "action", type:"movie", fYear:1994 }){
    id,title
  }
}
```
```graphql
mutation{
    deleteFilm(id:1){
        id,title
    }
}
```