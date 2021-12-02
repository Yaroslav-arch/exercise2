package com.example.exercise2;

import com.example.exercise2.dto.*;
import com.example.exercise2.dto.comparisonResults.MovieComparisonResult;
import com.example.exercise2.service.MovieService;
import com.example.exercise2.utils.MovieStatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MovieServiceTest {

    @Inject
    private MovieService movieService;
    static List<MovieDto> movies1 = new ArrayList<>();
    static List<MovieDto> movies2 = new ArrayList<>();
    static List<MovieDto> movies3 = new ArrayList<>();
    static MovieDtoList movieDtoList1 = new MovieDtoList();
    static MovieDtoList movieDtoList2 = new MovieDtoList();
    static MovieDtoList movieDtoList3 = new MovieDtoList();
    static MovieComparisonResult result = new MovieComparisonResult();
    static MovieDto movieDto1;
    static MovieDto movieDto2;
    static MovieDto movieDto3;

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
        UserDto userDto1 = new UserDto(2L, "User666");
        List<UserDto> users = new ArrayList<>();
        List<UserDto> users1 = new ArrayList<>();
        users.add(userDto);
        users1.add(userDto1);
        movieDto1 = MovieDto.builder().id(1L).name("Mad Max").actors(actorDtoList).directors(directors).genres(genres).users(users).build();
        movieDto2 = MovieDto.builder().id(2L).name("Lethal Weapon").actors(actorDtoList).directors(directors).genres(genres).users(users).build();
        movieDto3 = MovieDto.builder().id(3L).name("Mad Max").actors(actorDtoList).directors(directors).genres(genres).users(users1).build();
        movies1.add(movieDto1);
        movies1.add(movieDto2);
        movieDtoList1.setMovies(movies1);

        movies2.add(movieDto1);
        movieDtoList2.setMovies(movies2);

        movies3.add(movieDto3);
        movieDtoList3.setMovies(movies3);

        result.setMovieName(movieDto2.getName());
    }

//    @Test
//    public void compareMovieListsTest() {
//        Assertions.assertTrue(movieService.compareMovieLists(movieDtoList1, movieDtoList1));
//        Assertions.assertFalse(movieService.compareMovieLists(movieDtoList1, movieDtoList2));
//    }

    @Test
    public void compareWithResultTestWithEqualLists() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<MovieComparisonResult> movieComparisonResults = movieService.compareWithResult(movieDtoList1, movieDtoList1);
        Assertions.assertEquals(MovieStatusEnum.MOVIE_LISTS_ARE_EQUAL, movieComparisonResults.get(0).getStatus());
    }

    @Test
    public void compareWithResultTestWithDifferenceInOneMovie() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<MovieComparisonResult> movieComparisonResults = movieService.compareWithResult(movieDtoList2, movieDtoList3);
        Assertions.assertEquals(MovieStatusEnum.HERE_IS_THE_DIFFERENCE, movieComparisonResults.get(0).getStatus());
        Assertions.assertEquals(movieDto1.getName(), movieComparisonResults.get(0).getMovieName());
    }

    @Test
    public void compareWithResultTestWithDifferentMoviesInLists() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<MovieComparisonResult> movieComparisonResults = movieService.compareWithResult(movieDtoList1, movieDtoList2);
        Assertions.assertEquals(MovieStatusEnum.EXISTS_ONLY_IN_NEO4J, movieComparisonResults.get(0).getStatus());
        Assertions.assertEquals(movieDto2.getName(), movieComparisonResults.get(0).getMovieName());
    }
}
