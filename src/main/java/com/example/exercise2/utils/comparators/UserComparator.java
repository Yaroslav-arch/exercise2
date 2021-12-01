package com.example.exercise2.utils.comparators;

import com.example.exercise2.dto.UserDto;
import com.example.exercise2.dto.comparisonResults.UserComparisonResult;
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

    public UserComparisonResult getUsersDifference(List<UserDto> usersNeo4j, List<UserDto> usersSql) {
        UserComparisonResult result = new UserComparisonResult();
        for (UserDto m1 : usersNeo4j) {
            if (!usersSql.contains(m1)) {
                result.getNeo4j().add(m1);
                if (!result.isFlag()){
                    result.setFlag(true);
                }
            }
        }
        for (UserDto m2 : usersSql) {
            if (!usersNeo4j.contains(m2)) {
                result.getSql().add(m2);
                if (!result.isFlag()){
                    result.setFlag(true);
                }
            }
        }
        return result;
    }
}
