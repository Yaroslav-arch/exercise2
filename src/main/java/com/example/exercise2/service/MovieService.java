package com.example.exercise2.service;

import com.example.exercise2.dto.MovieDtoList;
import com.example.exercise2.dto.comparisonResults.MovieComparisonResult;
import com.example.exercise2.utils.comparators.MovieComparator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class MovieService {
    private final MovieComparator comparator;

    @Inject
    public MovieService(MovieComparator comparator) {
        this.comparator = comparator;
    }

//    public boolean compareMovieLists(MovieDtoList neo4jMovies,MovieDtoList sqlMovies) {
//        return comparator.compareMovieLists(neo4jMovies, sqlMovies);
//    }

    public List<MovieComparisonResult> compareWithResult(MovieDtoList neo4jMovies, MovieDtoList sqlMovies) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return comparator.compareWithResult(neo4jMovies, sqlMovies);
    }
}
