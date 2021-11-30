package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.GenreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreComparisonResult {

    private boolean flag = false;
    private List<GenreDto> neo4jGenres = new ArrayList<>();
    private List<GenreDto> sqlGenres = new ArrayList<>();

    @Override
    public String toString() {
        return "GenreComparisonResult{" +
                "neo4jGenres=" + neo4jGenres +
                ", sqlGenres=" + sqlGenres +
                '}';
    }
}
