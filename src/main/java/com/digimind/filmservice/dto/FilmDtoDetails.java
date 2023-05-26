package com.digimind.filmservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FilmDtoDetails {
    public String title;
    public String year;
    public String rated;
    public String released;
    public String runtime;
    public String genre;
    public String director;
    public String writer;
    public String actors;
    public String plot;
    public String language;
    public String country;
    public String awards;
    public String type;
    public String boxOffice;
    public String production;
    public String website;
}
