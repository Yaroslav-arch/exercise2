package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComparisonResult {

    private boolean flag = false;
    private List<UserDto> neo4jUsers = new ArrayList<>();
    private List<UserDto> sqlUsers = new ArrayList<>();

    @Override
    public String toString() {
        return "UserComparisonResult{" +
                "neo4jUsers=" + neo4jUsers +
                ", sqlUsers=" + sqlUsers +
                '}';
    }
}
