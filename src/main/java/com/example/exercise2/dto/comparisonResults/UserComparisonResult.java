package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.UserDto;
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
public class UserComparisonResult extends BasicComparisonResult{

    private boolean flag = false;
    private List<UserDto> neo4j = new ArrayList<>();
    private List<UserDto> sql = new ArrayList<>();

    @Override
    public String toString() {
        return "UserComparisonResult{" +
                "neo4jUsers=" + neo4j +
                ", sqlUsers=" + sql +
                '}';
    }
}
