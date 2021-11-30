package com.example.exercise2.dto.comparisonResults;

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

    private ActorComparisonResult actorsDifference;
    private DirectorComparisonResult directorsDifference;
    private GenreComparisonResult genresDifference;
    private UserComparisonResult usersDifference;
}
