package com.digimind.filmservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FilmDto {
    private String title;
    private String year;
    private String genre;
    private String type;
}
