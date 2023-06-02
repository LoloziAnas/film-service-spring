package com.digimind.filmservice.controller;

import com.digimind.filmservice.dto.FilmDto;
import com.digimind.filmservice.mapper.FilmMapper;
import com.digimind.filmservice.model.Film;
import com.digimind.filmservice.repository.FilmRepository;
import com.digimind.filmservice.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class FilmGraphQLController {
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    @QueryMapping
    public List<Film> allFilms(){
        return filmRepository.findAll();
    }
    @QueryMapping
    public List<Film> getFilmsByGenre(@Argument String genre){
        return filmRepository.findByGenreContainingIgnoreCase(genre);
    }
    @QueryMapping
    public Film filmById(@Argument Long id){
        return filmRepository.findById(id).orElseThrow();
    }
    @MutationMapping
    public Film saveFilm(@Argument FilmDto filmRequest){
        return filmRepository.save(filmMapper.mapFilmDtoToFim(filmRequest));
    }
    @MutationMapping
    public Film deleteFilm(@Argument Long id){
        var film = filmRepository.findById(id).get();
        filmRepository.delete(film);
        return film;
    }
}
