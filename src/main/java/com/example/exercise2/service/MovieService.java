package com.example.exercise2.service;

import com.example.exercise2.utils.comparators.MovieComparator;
import com.example.exercise2.utils.MoviesConverter;
import com.example.exercise2.utils.MoviesDownloader;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class MovieService {
    private final MoviesDownloader downloader;
    private final MoviesConverter converter;
    private final MovieComparator comparator;

    URI neo4jUri = new URI("http://localhost:8888/movies/all");
    URI sqlUri = new URI("http://localhost:8080/movies/all");

    @Inject
    public MovieService(MoviesDownloader downloader, MoviesConverter converter, MovieComparator comparator) throws URISyntaxException {
        this.downloader = downloader;
        this.converter = converter;
        this.comparator = comparator;
    }

    public boolean compareMovieLists() throws IOException, InterruptedException {
        return comparator.compareMovieLists(
                converter.convertMovies(downloader.downloadMovies(neo4jUri)),
                converter.convertMovies(downloader.downloadMovies(sqlUri))
        );
    }
}
