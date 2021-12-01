package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.MovieDto;
import com.example.exercise2.dto.MovieDtoList;
import com.example.exercise2.dto.comparisonResults.MovieComparisonResult;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieComparator {

    private final ActorComparator actorComparator;
    private final DirectorComparator directorComparator;
    private final GenreComparator genreComparator;
    private final UserComparator userComparator;

    @Inject
    public MovieComparator(ActorComparator actorComparator, DirectorComparator directorComparator, GenreComparator genreComparator, UserComparator userComparator) {
        this.actorComparator = actorComparator;
        this.directorComparator = directorComparator;
        this.genreComparator = genreComparator;
        this.userComparator = userComparator;
    }

    public boolean compareMovieLists(MovieDtoList movieDtoListNeo4j, MovieDtoList movieDtoListSql) {
//        List<Boolean> flag = new ArrayList<>();
        List<MovieDto> moviesNeo4j = movieDtoListNeo4j.getMovies();
        List<MovieDto> moviesSql = movieDtoListSql.getMovies();
        if (moviesNeo4j.size() == moviesSql.size()) {
            return moviesNeo4j.stream().anyMatch(one -> moviesSql.stream()
                    .anyMatch(two -> compareMovies(one, two)));

//            for (MovieDto m1 : moviesNeo4j) {
//                for (MovieDto m2 : moviesSql) {
//                    flag.add(compareMovies(m1, m2));
//                }
//            }
//            return flag.contains(Boolean.FALSE);
        }
        return false;
    }

    private boolean compareMovies(MovieDto movieNeo4j, MovieDto movieSql) {
        return movieNeo4j.getName().equals(movieSql.getName())
                && movieNeo4j.getDuration() == movieSql.getDuration()
                && actorComparator.compareActorLists(movieNeo4j.getActors(), movieSql.getActors())
                && directorComparator.compareDirectorLists(movieNeo4j.getDirectors(), movieSql.getDirectors())
                && genreComparator.compareGenreLists(movieNeo4j.getGenres(), movieSql.getGenres())
                && userComparator.compareUserLists(movieNeo4j.getUsers(), movieSql.getUsers());

    }

    public List<MovieComparisonResult> compareWithResult(MovieDtoList movieDtoListNeo4j, MovieDtoList movieDtoListSql) {
        List<MovieDto> moviesNeo4j = movieDtoListNeo4j.getMovies();
        List<MovieDto> moviesSql = movieDtoListSql.getMovies();
        List<MovieComparisonResult> results = new ArrayList<>();
        MovieComparisonResult result = new MovieComparisonResult();

        for (MovieDto m1 : moviesNeo4j) {
            for (MovieDto m2 : moviesSql) {
                if (m1.getName().equals(m2.getName())) {
                    result = compareMoviesResult(m1, m2);
                    if (!result.getStatus().equals("Movie Lists Are Equal")) {
                        result.setMovieName(m1.getName());
                        results.add(result);
                    }
                }
                if (!moviesSql.contains(m1)) {
                    result.setMovieName("Only in Neo4j: " + m1.getName());
                }
                if (!moviesNeo4j.contains(m2)) {
                    result.setMovieName("Only in Sql: " + m2.getName());
                }

            }
        }

        return results;
    }

    private MovieComparisonResult compareMoviesResult(MovieDto movieNeo4j, MovieDto movieSql) {

        MovieComparisonResult result = new MovieComparisonResult();

        if (movieNeo4j.getDuration() != movieSql.getDuration()) {
            result.setNeo4jMovieDuration(movieNeo4j.getDuration());
            result.setSqlMovieDuration(movieSql.getDuration());
            result.setStatus("");
        }

        result.setActorsDifference(actorComparator.getActorsDifference(movieNeo4j.getActors(), movieSql.getActors()));
        result.setDirectorsDifference(directorComparator.getDirectorsDifference(movieNeo4j.getDirectors(), movieSql.getDirectors()));
        result.setGenresDifference(genreComparator.getGenresDifference(movieNeo4j.getGenres(), movieSql.getGenres()));
        result.setUsersDifference(userComparator.getUsersDifference(movieNeo4j.getUsers(), movieSql.getUsers()));

        if (result.getActorsDifference().isFlag()
                || result.getDirectorsDifference().isFlag()
                || result.getGenresDifference().isFlag()
                || result.getUsersDifference().isFlag()) {
            result.setStatus("Here is the difference between the movies");
        }

        return result;
    }

}
