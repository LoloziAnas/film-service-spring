package com.digimind.filmservice.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OmdbFilmResult {
    @JsonProperty("Title")
    public String title;
    @JsonProperty("Year")
    public String year;
    @JsonProperty("Rated")
    public String rated;
    @JsonProperty("Released")
    public String released;
    @JsonProperty("Runtime")
    public String runtime;
    @JsonProperty("Genre")
    public String genre;
    @JsonProperty("Director")
    public String director;
    @JsonProperty("Writer")
    public String writer;
    @JsonProperty("Actors")
    public String actors;
    @JsonProperty("Plot")
    public String plot;
    @JsonProperty("Language")
    public String language;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("Awards")
    public String awards;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("DVD")
    public String dVD;
    @JsonProperty("BoxOffice")
    public String boxOffice;
    @JsonProperty("Production")
    public String production;
    @JsonProperty("Website")
    public String website;

}

