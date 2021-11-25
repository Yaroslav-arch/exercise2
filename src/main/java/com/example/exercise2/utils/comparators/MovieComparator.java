package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.MovieDto;
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

    public boolean compareMovieLists(List<MovieDto> moviesNeo4j, List<MovieDto> moviesSql) {
//        List<Boolean> flag = new ArrayList<>();
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

    public boolean compareMovies(MovieDto movieNeo4j, MovieDto movieSql) {
        return movieNeo4j.getName().equals(movieSql.getName())
                && movieNeo4j.getDuration() == movieSql.getDuration()
                && actorComparator.compareActorLists(movieNeo4j.getActors(), movieSql.getActors())
                && directorComparator.compareDirectorLists(movieNeo4j.getDirectors(), movieSql.getDirectors())
                && genreComparator.compareGenreLists(movieNeo4j.getGenres(), movieSql.getGenres())
                && userComparator.compareUserLists(movieNeo4j.getUsers(), movieSql.getUsers());

    }
}
