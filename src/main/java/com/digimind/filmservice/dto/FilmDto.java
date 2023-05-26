package com.digimind.filmservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FilmDto {
    private String title;
    private Integer year;
    private String genre;
    private String type;
}
