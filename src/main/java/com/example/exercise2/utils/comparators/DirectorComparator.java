package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.DirectorDto;
import com.example.exercise2.dto.comparisonResults.DirectorComparisonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DirectorComparator {
    public boolean compareDirectorLists(List<DirectorDto> directorsNeo4j, List<DirectorDto> DirectorsSql) {
        if (directorsNeo4j.size() == DirectorsSql.size()) {
            return DirectorsSql.containsAll(directorsNeo4j);
        }
        return false;
    }
    
    public DirectorComparisonResult getDirectorsDifference(List<DirectorDto> directorsNeo4j, List<DirectorDto> directorsSql) {
        DirectorComparisonResult result = new DirectorComparisonResult();
        for (DirectorDto m1 : directorsNeo4j) {
            if (!directorsSql.contains(m1)){
                result.getNeo4jDirectors().add(m1);
                if (!result.isFlag()){
                    result.setFlag(true);
                }
            }
        }
        for (DirectorDto m2 : directorsSql) {
            if (!directorsNeo4j.contains(m2)){
                result.getSqlDirectors().add(m2);
                if (!result.isFlag()){
                    result.setFlag(true);
                }
            }
        }
        return result;
    }
}

