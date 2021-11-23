package com.example.exercise2.controllers;

import com.example.exercise2.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.IOException;

@RestController
public class MovieRestController {

    private final MovieService movieService;

    @Inject
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/check")
    public boolean getAllMovies() throws IOException, InterruptedException {
        return movieService.compareMovieLists();
    }

}
