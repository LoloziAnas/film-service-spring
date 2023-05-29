package com.digimind.filmservice.controller;

import com.digimind.filmservice.dto.AddFilmDto;
import com.digimind.filmservice.dto.FilmDtoDetails;
import com.digimind.filmservice.dto.FilmDtoResponse;
import com.digimind.filmservice.model.Film;
import com.digimind.filmservice.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"**","http://localhost:4200/","http://localhost:8080/"})
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public FilmDtoResponse searchFilmsByGenre(@RequestParam String genre) {
        return filmService.searchFilmsByGenre(genre);
    }
    @PostMapping("/films")
    public Film createFilm(@RequestBody AddFilmDto addFilmDto){
        return filmService.createFilm(addFilmDto);
    }
    @GetMapping("/films/search")
    public FilmDtoResponse searchFilmsByYearAndTitle(@RequestParam int year, @RequestParam String title) {
        return filmService.searchFilmsByYearAndTitle(year, title);
    }

    @GetMapping("/films/{imdbID}")
    public FilmDtoDetails getFilmDetails(@PathVariable String imdbID) {
        return filmService.getFilmDetails(imdbID);
    }
}

