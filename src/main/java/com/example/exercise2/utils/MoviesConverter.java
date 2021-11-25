package com.example.exercise2.utils;

import com.example.exercise2.dto.MovieDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class MoviesConverter {
    public List<MovieDto> convertMovies(String body) throws IOException {

        ObjectMapper mapper = JsonMapper.builder()
                .findAndAddModules()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                .build();


        return mapper.readValue(body, new TypeReference<>() {
        });
    }
}
