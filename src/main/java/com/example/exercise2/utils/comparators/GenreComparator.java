package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.GenreDto;
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
}
