package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserComparator {
    public boolean compareUserLists(List<UserDto> usersNeo4j, List<UserDto> usersSql) {
        if (usersNeo4j.size() == usersSql.size()) {
            return usersSql.containsAll(usersNeo4j);
        }
        return false;
    }
}
