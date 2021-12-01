package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.GenreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreComparisonResult extends BasicComparisonResult{

    private boolean flag = false;
    private List<GenreDto> neo4j = new ArrayList<>();
    private List<GenreDto> sql = new ArrayList<>();

    @Override
    public String toString() {
        return "GenreComparisonResult{" +
                "neo4jGenres=" + neo4j +
                ", sqlGenres=" + sql +
                '}';
    }
}
