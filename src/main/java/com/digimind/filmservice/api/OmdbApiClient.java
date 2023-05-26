package com.digimind.filmservice.api;

import com.digimind.filmservice.api.response.OmdbFilmListResult;
import com.digimind.filmservice.api.response.OmdbFilmResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class OmdbApiClient {
    @Autowired
    private final RestTemplate restTemplate;
    @Value("${omdb.api.key}")
    private String apiKey;

    public OmdbApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    public OmdbFilmListResult searchFilmsByYearAndTitle(int year, String title) {

        String url = String.format("http://www.omdbapi.com/?apikey=%s&y=%d&s=%s", apiKey, year, title);
        log.info("Url search film by year and title "+url);
        return restTemplate.getForObject(url, OmdbFilmListResult.class);
    }

    public OmdbFilmResult getFilmDetails(String imdbID) {
        String url = String.format("http://www.omdbapi.com/?apikey=%s&i=%s", apiKey, imdbID);
        log.info("Url for getting details for a specific film "+url);
        return restTemplate.getForObject(url, OmdbFilmResult.class);
    }
}

