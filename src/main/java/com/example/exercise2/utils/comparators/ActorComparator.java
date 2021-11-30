package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.ActorDto;
import com.example.exercise2.dto.comparisonResults.ActorComparisonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorComparator {
    public boolean compareActorLists(List<ActorDto> actorsNeo4j, List<ActorDto> actorsSql) {
        if (actorsNeo4j.size() == actorsSql.size()) {
            return actorsSql.containsAll(actorsNeo4j);
        }
        return false;
    }

    public ActorComparisonResult getActorsDifference(List<ActorDto> actorsNeo4j, List<ActorDto> actorsSql) {
        ActorComparisonResult result = new ActorComparisonResult();
        for (ActorDto m1 : actorsNeo4j) {
           if (!actorsSql.contains(m1)){
               result.getNeo4jActors().add(m1);
               if (!result.isFlag()){
                   result.setFlag(true);
               }
           }
        }
        for (ActorDto m2 : actorsSql) {
            if (!actorsNeo4j.contains(m2)){
                result.getSqlActors().add(m2);
                if (!result.isFlag()){
                    result.setFlag(true);
                }
            }
        }
        return result;
    }
}
