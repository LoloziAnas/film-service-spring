package com.digimind.filmservice.service;

public interface FilmServiceI {
    
    default void deleteFilm(long id){
        System.out.println("Film with the id was deleted "+ id);
    }
}
