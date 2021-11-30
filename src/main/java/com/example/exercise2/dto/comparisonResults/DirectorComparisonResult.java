package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.DirectorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorComparisonResult {

    private boolean flag = false;
    private List<DirectorDto> neo4jDirectors = new ArrayList<>();
    private List<DirectorDto> sqlDirectors = new ArrayList<>();

    @Override
    public String toString() {
        return "DirectorComparisonResult{" +
                "neo4jDirectors=" + neo4jDirectors +
                ", sqlDirectors=" + sqlDirectors +
                '}';
    }
}
