package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.ActorDto;
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
public class ActorComparisonResult extends BasicComparisonResult{

    private boolean flag = false;
    private List<ActorDto> neo4j = new ArrayList<>();
    private List<ActorDto> sql = new ArrayList<>();

    @Override
    public String toString() {
        return "ActorComparisonResult{" +
                "neo4jActors=" + neo4j +
                ", sqlActors=" + sql +
                '}';
    }
}
