package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.ActorDto;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class ActorComparator {
    public boolean compareActorLists(List<ActorDto> actorsNeo4j, List<ActorDto> actorsSql) {
        if (actorsNeo4j.size() == actorsSql.size()) {
            return actorsSql.containsAll(actorsNeo4j);
        }
        return false;
    }
}
