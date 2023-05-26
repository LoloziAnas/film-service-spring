package com.digimind.filmservice.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search{
    @JsonProperty("Title")
    public String title;
    @JsonProperty("Year")
    public String year;
    public String imdbID;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Poster")
    public String poster;
}
