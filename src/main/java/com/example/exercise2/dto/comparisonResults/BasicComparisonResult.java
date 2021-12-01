package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.BasicDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class BasicComparisonResult {
    private boolean flag;
    private List<? extends BasicDto> neo4j = new ArrayList<>();
    private List<? extends BasicDto> sql = new ArrayList<>();

    @Override
    public String toString() {
        return "BasicComparisonResult{" +
                "neo4j=" + neo4j +
                ", sql=" + sql +
                '}';
    }
}
