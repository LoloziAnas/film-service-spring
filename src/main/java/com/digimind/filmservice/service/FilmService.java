package com.digimind.filmservice.service;
import com.digimind.filmservice.api.OmdbApiClient;
import com.digimind.filmservice.api.response.OmdbFilmResult;
import com.digimind.filmservice.api.response.Search;
import com.digimind.filmservice.dto.AddFilmDto;
import com.digimind.filmservice.dto.FilmDto;
import com.digimind.filmservice.dto.FilmDtoDetails;
import com.digimind.filmservice.dto.FilmDtoResponse;
import com.digimind.filmservice.model.Film;
import com.digimind.filmservice.repository.FilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FilmService implements FilmServiceI{
    private final FilmRepository filmRepository;
    private final OmdbApiClient omdbApiClient;


    @Autowired
    public FilmService(FilmRepository filmRepository, OmdbApiClient omdbApiClient) {
        this.filmRepository = filmRepository;
        this.omdbApiClient = omdbApiClient;
    }
    public Film createFilm(AddFilmDto filmDto) {
        log.info("film "+filmDto);
        return filmRepository.save(Film.builder()
                .title(filmDto.getTitle())
                .fYear(filmDto.getYear())
                .type(filmDto.getType())
                .genre(filmDto.getGenre())
                .build());
    }
    public FilmDtoResponse searchFilmsByGenre(String genre) {
        var filmList = filmRepository.findByGenreContainingIgnoreCase(genre);
        Map<Integer, FilmDto> filmDtoMap = filmList.stream().collect(Collectors.toMap(Film::getId,this::mapFilmToFilmDto ));

        log.info("search films by genre film map"+ filmDtoMap.keySet());
        var filmDtoList = filmList.stream().map(this::mapFilmToFilmDto).toList();
        return new FilmDtoResponse(filmDtoList, String.valueOf(filmList.size()));
    }
    public FilmDtoResponse searchFilmsByYearAndTitle(int year, String title) {
        var result = omdbApiClient.searchFilmsByYearAndTitle(year, title);
        log.info("search film by year and title result: "+result.totalResults);

        var filmsDto =  result.search.stream().map(this::convertFromOmdbFilmListResulSearchtToFilm).toList();
        return new FilmDtoResponse(filmsDto, result.totalResults);
    }

    public FilmDtoDetails getFilmDetails(String imdbID) {
        OmdbFilmResult omdbFilmResult = omdbApiClient.getFilmDetails(imdbID);
        log.info(omdbFilmResult.title);
        return mapOmdbFilmResultToFilmDtoDetails(omdbFilmResult);
    }
    private FilmDto convertFromOmdbFilmListResulSearchtToFilm (Search omdbFilmListResult){
        return FilmDto.builder()
                .title(omdbFilmListResult.title)
                .year(omdbFilmListResult.year)
                .type(omdbFilmListResult.type)
                .build();
    }
    private FilmDtoDetails mapOmdbFilmResultToFilmDtoDetails(OmdbFilmResult omdbFilmResult){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(omdbFilmResult, FilmDtoDetails.class);
    }
    private FilmDto mapFilmToFilmDto(Film film){
        return FilmDto.builder()
                .title(film.getTitle())
                .genre(film.getGenre())
                .year(String.valueOf(film.getFYear()))
                .type(film.getType())
                .build();
    }


}

