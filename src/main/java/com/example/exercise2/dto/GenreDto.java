package com.example.exercise2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class GenreDto {
    private Long id;
    private String name;

    public GenreDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreDto genreDto = (GenreDto) o;
        return name.equals(genreDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
