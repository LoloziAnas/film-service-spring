package com.digimind.filmservice.controller;

import com.digimind.filmservice.dto.AddFilmDto;
import com.digimind.filmservice.dto.FilmDto;
import com.digimind.filmservice.dto.FilmDtoResponse;
import com.digimind.filmservice.model.Film;
import com.digimind.filmservice.service.FilmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FilmControllerTest {

    @Mock
    private FilmService filmService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @InjectMocks
    private FilmController filmController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldCreateFilm() throws Exception {
        AddFilmDto filmDto = AddFilmDto.builder().title("Test").genre("test").year(2012).type("test").build();
        String filmRequestString = objectMapper.writeValueAsString(filmDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/films")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(filmRequestString))
                .andExpect(status().isOk());
        //Assertions.assertEquals(1, productRepository.findAll().size());
    }
    @Test
    void searchFilmsByGenre_ReturnsListOfFilms() throws Exception {
        // Arrange
        String genre = "Action";
        List<FilmDto> films = Arrays.asList(
                new FilmDto("Star Wars: Episode IV - A New Hope", 1977, "Action, Adventure, Fantasy, Sci-Fi", "serie"),
                new FilmDto("Star Wars: Episode V - The Empire Strikes Back", 1980, "Action, Adventure, Fantasy, Sci-Fi", "movie")
        );
        FilmDtoResponse filmDtoResponse = new FilmDtoResponse();
        filmDtoResponse.setFilms(films);
        filmDtoResponse.setTotal(String.valueOf(films.size()));
        when(filmService.searchFilmsByGenre(genre)).thenReturn(filmDtoResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/films")
                        .param("genre", genre)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(films.size()));
    }

}
