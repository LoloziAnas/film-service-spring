package com.digimind.filmservice.config;

import com.digimind.filmservice.model.Film;
import com.digimind.filmservice.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitData {

    @Bean
    public CommandLineRunner initFilms(FilmRepository filmRepository){
        return args -> {
            Film f = Film.builder().title("Star Wars: Episode IV - A New Hope").fYear(1977).genre("Action, Adventure, Fantasy, Sci-Fi").type("serie").build();
            Film f1 = Film.builder().title("Star Wars: Episode V - The Empire Strikes Back").fYear(1980).genre("Action, Adventure, Fantasy, Sci-Fi").type("movie").build();
            filmRepository.save(f);
            filmRepository.save(f1);
        };
    }
}
