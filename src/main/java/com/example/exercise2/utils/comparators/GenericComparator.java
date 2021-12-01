package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.ActorDto;
import com.example.exercise2.dto.GenericDto;
import com.example.exercise2.dto.comparisonResults.BasicComparisonResult;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
public class GenericComparator<T extends GenericDto> {
    public boolean compareLists(List<ActorDto> actorsNeo4j, List<ActorDto> actorsSql) {
        if (actorsNeo4j.size() == actorsSql.size()) {
            return actorsSql.containsAll(actorsNeo4j);
        }
        return false;
    }

    public <G extends BasicComparisonResult<T>> G getDtoDifference(List<T> neo4jDtos, List<T> sqlDtos) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        G result = ((Class<G>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]).getDeclaredConstructor().newInstance();
        for (T m1 : neo4jDtos) {
            if (!sqlDtos.contains(m1)) {
                result.getNeo4j().add(m1);
                if (!result.isFlag()) {
                    result.setFlag(true);
                }
            }
        }
        for (T m2 : sqlDtos) {
            if (!neo4jDtos.contains(m2)) {
                result.getSql().add(m2);
                if (!result.isFlag()) {
                    result.setFlag(true);
                }
            }
        }
        return result;
    }

}
