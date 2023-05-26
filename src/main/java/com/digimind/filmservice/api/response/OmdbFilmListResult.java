package com.digimind.filmservice.api.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class OmdbFilmListResult{
    @JsonProperty("Search")
    public ArrayList<Search> search;
    public String totalResults;
    @JsonProperty("Response")
    public String response;
}

