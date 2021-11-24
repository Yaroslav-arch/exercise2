package com.example.exercise2.service;

import com.example.exercise2.utils.MoviesConverter;
import com.example.exercise2.utils.MoviesDownloader;
import com.example.exercise2.utils.comparators.MovieComparator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;

@Service
public class MovieService {
    private final MoviesDownloader downloader;
    private final MoviesConverter converter;
    private final MovieComparator comparator;

    @Inject
    public MovieService(MoviesDownloader downloader, MoviesConverter converter, MovieComparator comparator) {
        this.downloader = downloader;
        this.converter = converter;
        this.comparator = comparator;
    }

    public boolean compareMovieLists() throws IOException, InterruptedException {
        return comparator.compareMovieLists(
                converter.convertMovies(downloader.getMoviesFromNeo4j()),
                converter.convertMovies(downloader.getMoviesFromSql())
        );
    }
}
