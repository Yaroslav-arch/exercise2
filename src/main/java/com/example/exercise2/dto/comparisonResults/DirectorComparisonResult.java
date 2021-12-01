package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.DirectorDto;
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
public class DirectorComparisonResult extends BasicComparisonResult{

    private boolean flag = false;
    private List<DirectorDto> neo4j = new ArrayList<>();
    private List<DirectorDto> sql = new ArrayList<>();

    @Override
    public String toString() {
        return "DirectorComparisonResult{" +
                "neo4jDirectors=" + neo4j +
                ", sqlDirectors=" + sql +
                '}';
    }
}
