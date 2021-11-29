package com.example.exercise2.controllers;

import com.example.exercise2.dto.MovieDto;
import com.example.exercise2.dto.MovieDtoList;
import com.example.exercise2.service.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.List;

@RestController
public class MovieRestController {

    @Value("${connection.scheme}")
    String scheme;
    @Value("${neo4j.url}")
    String neo4jUrl;
    @Value("${sql.url}")
    String sqlUrl;
    @Value("${neo4j.port}")
    String neo4jPort;
    @Value("${sql.port}")
    String sqlPort;
    @Value("${movie.urn}")
    String urn;

    private final MovieService movieService;

    @Inject
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/check")
    public boolean getAllMovies() {
        return movieService.compareMovieLists(getMovies(neo4jUrl, neo4jPort), getMovies(sqlUrl, sqlPort));
    }

    private List<MovieDto> getMovies(String url, String port) {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.newInstance()
                .scheme(scheme).host(url).port(port).path(urn).build().toUri();
        ResponseEntity<MovieDtoList> responseEntity = restTemplate.getForEntity(uri, MovieDtoList.class);
        MovieDtoList movieDtoList = responseEntity.getBody();
        return movieDtoList.getMovies();
    }
}
