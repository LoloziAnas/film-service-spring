package com.digimind.filmservice.dto;

import com.digimind.filmservice.model.Film;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FilmDtoResponse {
    private List<FilmDto> films;
    private String total;
}
