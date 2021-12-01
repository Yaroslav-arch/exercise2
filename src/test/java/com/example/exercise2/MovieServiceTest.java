package com.example.exercise2;

import com.example.exercise2.dto.*;
import com.example.exercise2.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MovieServiceTest {

    @Inject
    private MovieService movieService;
    static List<MovieDto> movies = new ArrayList<>();
    static List<MovieDto> otherMovies = new ArrayList<>();
    static MovieDtoList movieDtoList1 = new MovieDtoList();
    static MovieDtoList movieDtoList2 = new MovieDtoList();

    @BeforeAll
    static void setup() {
        ActorDto actorDto = new ActorDto(1L, "Mel Gibson");
        List<ActorDto> actorDtoList = new ArrayList<>();
        actorDtoList.add(actorDto);
        GenreDto genreDto = new GenreDto(1L, "action");
        List<GenreDto> genres = new ArrayList<>();
        genres.add(genreDto);
        DirectorDto directorDto = new DirectorDto(1L, "Chris Nolan");
        List<DirectorDto> directors = new ArrayList<>();
        directors.add(directorDto);
        UserDto userDto = new UserDto(1L, "User123");
        List<UserDto> users = new ArrayList<>();
        users.add(userDto);
        MovieDto movieDto1 = MovieDto.builder().id(1L).name("Mad Max").actors(actorDtoList).directors(directors).genres(genres).users(users).build();
        MovieDto movieDto2 = MovieDto.builder().id(2L).name("Lethal Weapon").actors(actorDtoList).directors(directors).genres(genres).users(users).build();
        movies.add(movieDto1);
        movies.add(movieDto2);
        movieDtoList1.setMovies(movies);
        otherMovies.add(movieDto1);
        movieDtoList2.setMovies(otherMovies);

    }

    @Test
    public void compareMovieListsTest() {
        Assertions.assertTrue(movieService.compareMovieLists(movieDtoList1, movieDtoList1));
        Assertions.assertFalse(movieService.compareMovieLists(movieDtoList1, movieDtoList2));
    }
}
