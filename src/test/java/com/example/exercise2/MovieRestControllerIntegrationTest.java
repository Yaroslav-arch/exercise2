package com.example.exercise2;

import com.example.exercise2.dto.ActorDto;
import com.example.exercise2.dto.GenreDto;
import com.example.exercise2.dto.MovieDto;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieRestControllerIntegrationTest {

    @Inject
    private MockMvc mockMvc;

    List<MovieDto> movies = new ArrayList<>();

    @BeforeEach
    public void setup() {
        ActorDto actorDto = new ActorDto(1L, "Mel Gibson");
        List<ActorDto> actors = new ArrayList<>();
        actors.add(actorDto);
        GenreDto genre = new GenreDto(1L, "action");
        List<GenreDto> genres = new ArrayList<>();
        genres.add(genre);
        MovieDto movie1 = MovieDto.builder().id(1L).name("Mad Max").actors(actors).genres(genres).build();
        MovieDto movie2 = MovieDto.builder().id(2L).name("Lethal Weapon").actors(actors).genres(genres).build();
        movies.add(movie1);
        movies.add(movie2);
    }

//    @Test
//    public void getAllMoviesTest() throws Exception {
//        given(moviesDownloader.getMoviesFromNeo4j()).willReturn(movies);
//        given(moviesDownloader.getMoviesFromSql()).willReturn(movies);
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/check"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string("true"));
//    }

}
