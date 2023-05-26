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
    @JsonProperty("Genre")
    public String genre;
    @JsonProperty("Type")
    public String type;
}

