package com.upskill.movieland.controller;

import com.upskill.movieland.Mapper.MovieMapper;
import com.upskill.movieland.dto.MovieDto;
import com.upskill.movieland.entity.Movie;
import com.upskill.movieland.service.MovieService;
import com.upskill.movieland.sort.SortingProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@PropertySource({""})
@Slf4j
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDto> getAllMovies(@RequestParam(required = false) String sortField,
                                       @RequestParam(required = false) String sortDirection) {
        SortingProperties sortingProperties = new SortingProperties(sortField, sortDirection);
        List<Movie> movies = movieService.getAll(sortingProperties);
        log.debug("getAllMovies");
        return mapToDto(movies);
    }

    @GetMapping("/random")
    public List<MovieDto> getRandomMovies(@Value("${movie.random.quantity}") int quantity,
                                          @RequestParam(required = false) String sortField,
                                          @RequestParam(required = false) String sortDirection) {
        SortingProperties sortingProperties = new SortingProperties(sortField, sortDirection);
        List<Movie> movies = movieService.getRandomMovies(quantity, sortingProperties);
        log.debug("getAllMovies");
        return mapToDto(movies);
    }

    @GetMapping("/genre/{genreId}")
    public List<MovieDto> getMoviesByGenre(@PathVariable Integer genreId) {
        List<Movie> moviesByGenre = movieService.getMoviesByGenre(genreId);
        log.debug("get movies by genre id {}", genreId);
        return mapToDto(moviesByGenre);
    }

    private List<MovieDto> mapToDto(List<Movie> movies) {
        MovieMapper movieMapper = new MovieMapper();
        return movieMapper.map(movies);
    }


}
