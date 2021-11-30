package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.ActorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorComparisonResult {

    private boolean flag = false;
    private List<ActorDto> neo4jActors = new ArrayList<>();
    private List<ActorDto> sqlActors = new ArrayList<>();

    @Override
    public String toString() {
        return "ActorComparisonResult{" +
                "neo4jActors=" + neo4jActors +
                ", sqlActors=" + sqlActors +
                '}';
    }
}
