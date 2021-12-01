package com.example.exercise2.dto.comparisonResults;

import com.example.exercise2.dto.ActorDto;
import com.example.exercise2.dto.DirectorDto;
import com.example.exercise2.dto.GenreDto;
import com.example.exercise2.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieComparisonResult {

    private String status = "Movie Lists Are Equal";
    private String movieName;

    private Integer neo4jMovieDuration;
    private Integer sqlMovieDuration;

    private BasicComparisonResult<ActorDto> actorsDifference;
    private BasicComparisonResult<DirectorDto> directorsDifference;
    private BasicComparisonResult<GenreDto> genresDifference;
    private BasicComparisonResult<UserDto> usersDifference;
}
