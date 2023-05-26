package com.digimind.filmservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder @ToString
public class AddFilmDto {
    private String title;
    private Integer year;
    private String genre;
    private String type;
}
