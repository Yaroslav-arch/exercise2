package com.example.exercise2.service;

import com.example.exercise2.dto.MovieDto;
import com.example.exercise2.utils.comparators.MovieComparator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MovieService {
    private final MovieComparator comparator;

    @Inject
    public MovieService(MovieComparator comparator) {
        this.comparator = comparator;
    }

    public boolean compareMovieLists(List<MovieDto> neo4jMovies, List<MovieDto> sqlMovies) {
        return comparator.compareMovieLists(neo4jMovies, sqlMovies);
    }
}
