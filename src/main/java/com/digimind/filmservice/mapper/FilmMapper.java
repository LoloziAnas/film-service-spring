package com.digimind.filmservice.mapper;

import com.digimind.filmservice.dto.FilmDto;
import com.digimind.filmservice.model.Film;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {
    private final ModelMapper mapper = new ModelMapper();
    public Film mapFilmDtoToFim(FilmDto filmDto){
        return mapper.map(filmDto, Film.class);
    }
}
