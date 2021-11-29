package com.example.exercise2.controllers;

import com.example.exercise2.dto.MovieDto;
import com.example.exercise2.dto.MovieDtoList;
import com.example.exercise2.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.net.URI;
import java.util.List;

@RestController
public class MovieRestController {

    @Inject
    @Named("neo4jUri")
    private URI neo4jUri;

    @Inject()
    @Named("sqlUri")
    private URI sqlUri;

    private final MovieService movieService;
    private final RestTemplate restTemplate;

    @Inject
    public MovieRestController(MovieService movieService, RestTemplate restTemplate) {
        this.movieService = movieService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/check")
    public boolean getAllMovies() {
        return movieService.compareMovieLists(getMovies(neo4jUri), getMovies(sqlUri));
    }

    private List<MovieDto> getMovies(URI uri) {

        ResponseEntity<MovieDtoList> responseEntity = restTemplate.getForEntity(uri, MovieDtoList.class);
        MovieDtoList movieDtoList = responseEntity.getBody();
        return movieDtoList.getMovies();
    }
}
