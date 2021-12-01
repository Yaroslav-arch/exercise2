package com.example.exercise2.controllers;

import com.example.exercise2.dto.MovieDtoList;
import com.example.exercise2.dto.comparisonResults.MovieComparisonResult;
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

    private final URI neo4jUri;
    private final URI sqlUri;
    private final MovieService movieService;
    private final RestTemplate restTemplate;

    @Inject
    public MovieRestController(MovieService movieService, RestTemplate restTemplate, @Named("neo4jUri") URI neo4jUri, @Named("sqlUri") URI sqlUri) {
        this.movieService = movieService;
        this.restTemplate = restTemplate;
        this.neo4jUri=neo4jUri;
        this.sqlUri=sqlUri;
    }

    @GetMapping("/check")
    public boolean getAllMovies() {
        return movieService.compareMovieLists(getMovies(neo4jUri), getMovies(sqlUri));
    }

    @GetMapping("/check/result")
    public List<MovieComparisonResult> getComparisonResult(){
        return movieService.compareWithResult(getMovies(neo4jUri), getMovies(sqlUri));
    }

    private MovieDtoList getMovies(URI uri) {

        ResponseEntity<MovieDtoList> responseEntity = restTemplate.getForEntity(uri, MovieDtoList.class);
        return responseEntity.getBody();
    }
}
