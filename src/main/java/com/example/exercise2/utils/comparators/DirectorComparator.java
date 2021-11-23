package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.DirectorDto;
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
}

