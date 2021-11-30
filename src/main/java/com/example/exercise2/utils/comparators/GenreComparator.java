package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.GenreDto;
import com.example.exercise2.dto.comparisonResults.GenreComparisonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreComparator {
    public boolean compareGenreLists(List<GenreDto> genresNeo4j, List<GenreDto> genresSql) {
        if (genresNeo4j.size() == genresSql.size()) {
            return genresSql.containsAll(genresNeo4j);
        }
        return false;
    }

    public GenreComparisonResult getGenresDifference(List<GenreDto> genresNeo4j, List<GenreDto> genresSql) {
        GenreComparisonResult result = new GenreComparisonResult();
        for (GenreDto m1 : genresNeo4j) {
            if (!genresSql.contains(m1)){
                result.getNeo4jGenres().add(m1);
                if (!result.isFlag()){
                    result.setFlag(true);
                }
            }
        }
        for (GenreDto m2 : genresSql) {
            if (!genresNeo4j.contains(m2)){
                result.getSqlGenres().add(m2);
                if (!result.isFlag()){
                    result.setFlag(true);
                }
            }
        }
        return result;
    }
}
