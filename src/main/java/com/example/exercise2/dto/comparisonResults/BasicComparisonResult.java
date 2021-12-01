package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.GenericDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BasicComparisonResult<T extends GenericDto> {
    private boolean flag;
    private List<T> neo4j = new ArrayList<>();
    private List<T> sql = new ArrayList<>();

    @Override
    public String toString() {
        return "BasicComparisonResult{" +
                "neo4j=" + neo4j +
                ", sql=" + sql +
                '}';

    }

}
