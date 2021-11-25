package com.example.exercise2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int duration;
    @NotNull
    private List<ActorDto> actors;
    @NotNull
    private List<DirectorDto> directors;
    @NotNull
    private List<GenreDto> genres;
    @NotNull
    private List<UserDto> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return duration == movieDto.duration
                && name.equals(movieDto.name)
                && actors.equals(movieDto.actors)
                && directors.equals(movieDto.directors)
                && genres.equals(movieDto.genres)
                && users.equals(movieDto.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, actors, directors, genres, users);
    }
}
