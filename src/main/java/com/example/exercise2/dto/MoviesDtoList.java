package com.example.exercise2.dto;

import lombok.Value;

import java.util.List;

@Value
public class MoviesDtoList {
    List<MovieDto> movies;
}
