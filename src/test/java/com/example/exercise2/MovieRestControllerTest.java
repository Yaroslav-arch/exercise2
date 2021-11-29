package com.example.exercise2;

import com.example.exercise2.controllers.MovieRestController;
import com.example.exercise2.dto.MovieDto;
import com.example.exercise2.dto.MovieDtoList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@SpringBootTest
public class MovieRestControllerTest {

    @Inject
    private MovieRestController movieRestController;

    @Mock
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;
    private final ObjectMapper mapper = new ObjectMapper();
    URI neo4jUri = new URI("http://localhost:8888/movies/all");
    URI sqlUri = new URI("http://localhost:8889/movies/all");
//    @Value("${connection.scheme}")
//    private static String scheme;
//    @Value("${neo4j.url}")
//    private static String neo4jUrl;
//    @Value("${sql.url}")
//    private static String sqlUrl;
//    @Value("${neo4j.port}")
//    private static String neo4jPort;
//    @Value("${sql.port}")
//    private static String sqlPort;
//    @Value("${movie.urn}")
//    private static String urn;


    private MovieDtoList movieDtoList = new MovieDtoList(new ArrayList<>());

    public MovieRestControllerTest() throws URISyntaxException {
    }

    @BeforeEach
    public void init() {

//        restTemplate = new RestTemplate();
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
//          URI neo4jUri = new URI("http://localhost:8888/movies/all");
//          URI sqlUri = new URI("http://localhost:8889/movies/all");

//        mockServer = MockRestServiceServer.createServer(restTemplate);
        Mockito.when(restTemplate.getForEntity(
                        Mockito.anyString(),
                        ArgumentMatchers.any(Class.class)
                ))
                .thenReturn(new ResponseEntity(movieDtoList,HttpStatus.OK));

//        Mockito.when(restTemplate.getForEntity(
//                        neo4jUri, MovieDtoList.class))
//                .thenReturn(new ResponseEntity<>(movieDtoList, HttpStatus.OK));
//
//        Mockito.when(restTemplate.getForEntity(
//                        sqlUri, MovieDtoList.class))
//                .thenReturn(new ResponseEntity<>(movieDtoList, HttpStatus.OK));
    }

    @Test
    public void getAllMoviesTest() throws JsonProcessingException {

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

//        boolean equal = movieRestController.getAllMovies();
        Mockito.verify(restTemplate, Mockito.times(2));
        Assertions.assertTrue(movieRestController.getAllMovies());
    }
}
