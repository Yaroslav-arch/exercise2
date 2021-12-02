package com.example.exercise2;

import com.example.exercise2.controllers.MovieRestController;
import com.example.exercise2.dto.MovieDto;
import com.example.exercise2.dto.MovieDtoList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.net.URI;
import java.util.ArrayList;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@SpringBootTest
public class MovieRestControllerTest {

    @Inject
    private MovieRestController movieRestController;

    @Inject
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;
    private final ObjectMapper mapper = new ObjectMapper();

    @Inject
    @Named("neo4jUri")
    private URI neo4jUri;

    @Inject()
    @Named("sqlUri")
    private URI sqlUri;


    private final MovieDtoList movieDtoList = new MovieDtoList(new ArrayList<>());

    @BeforeEach
    public void init() {

        MovieDto movie = MovieDto.builder()
                .id(1L)
                .name("Some Movie")
                .duration(90)
                .actors(new ArrayList<>())
                .directors(new ArrayList<>())
                .genres(new ArrayList<>())
                .users(new ArrayList<>())
                .build();
        movieDtoList.getMovies().add(movie);

        mockServer = MockRestServiceServer.createServer(restTemplate);

    }

//    @Test
//    public void getAllMoviesTest() throws JsonProcessingException {
//
//        mockServer.expect(ExpectedCount.once(),
//                        requestTo(neo4jUri))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(movieDtoList))
//                );
//        mockServer.expect(ExpectedCount.once(),
//                        requestTo(sqlUri))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(movieDtoList))
//                );
//
//        boolean equal = movieRestController.getAllMovies();
//        mockServer.verify();
//        Assertions.assertTrue(equal);
//    }
}
