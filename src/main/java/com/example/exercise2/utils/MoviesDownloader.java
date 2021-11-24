package com.example.exercise2.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class MoviesDownloader {

    @Value("${neo4j.url}")
    String neo4jUrl;
    @Value("${sql.url}")
    String sqlUrl;
    @Value("${movie.urn}")
    String urn;

    public MoviesDownloader() {
    }

    public String getMoviesFromNeo4j() throws IOException, InterruptedException {
        return getMovies(neo4jUrl);
    }

    public String getMoviesFromSql() throws IOException, InterruptedException {
        return getMovies(sqlUrl);
    }

    private String getMovies(String url) throws IOException, InterruptedException {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(url).path(urn).build().toUri();

        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
