package com.example.exercise2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class DirectorDto {
    private Long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorDto directorDto = (DirectorDto) o;
        return name.equals(directorDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
